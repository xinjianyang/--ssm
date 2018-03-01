package com.shanghai.controller;

import com.shanghai.domain.service.CurdService;
import com.shanghai.domain.service.TestService;
import com.shanghai.pojo.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xinjian on 2018/2/28 0028.
 *
 * @author xinjian
 */
@Controller
public class HomeController {


    @Autowired
    private CurdService curdService;
    @Autowired
    private TestService service;

    @GetMapping("/login")
    public String hello(){
        return "login";
    }


    /**登录认证
     * @param username
     * @param password
     * @param request
     * @return
     */
    @PostMapping("/login")
    public String login(String username, String password, HttpServletRequest request,RedirectAttributes redirectAttributes) {
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            //subject.checkRole("admin");
            //service.add(12,34);

            return "home";
        }catch (AuthenticationException ex){
            redirectAttributes.addAttribute("message","账户密码错误");
            return "redirect:login";
        }catch (AuthorizationException ex){
            redirectAttributes.addAttribute("message","权限不足");
            System.out.println("权限不足");
            return "redirect:/login";
        }
    }

    /**安全退出
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/logout")
    public String logout(RedirectAttributes redirectAttributes){
        SecurityUtils.getSubject().logout();
        redirectAttributes.addAttribute("message","您已安全退出系统");
        return "redirect:/login";
    }

}
