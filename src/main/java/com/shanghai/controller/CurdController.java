package com.shanghai.controller;

import com.shanghai.domain.service.CurdService;
import com.shanghai.pojo.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by xinjian on 2018/2/28 0028.
 *
 * @author xinjian
 */
@Controller
public class CurdController {

    @Autowired
    private CurdService curdService;

    /**处理整个控制器类抛出的此类异常
     * @return
     *//*
    @ExceptionHandler(UnauthorizedException.class)
    public String handlerException(){
        return "error";
    }*/

    @RequiresRoles("admin")
    @GetMapping("/role/add")
    public String roleAdd(){
        return "role/add";
    }

    @PostMapping("/role/add")
    public String saveRole(Role role, Model model){
        curdService.saveRole(role);
        model.addAttribute("message","role新增成功");
        return "redirect:/role/add";
    }


    @RequiresRoles("admin")
    @GetMapping("/account/add")
    public String accountAdd(){
        return "account/add";
    }


    @PostMapping("/account/add")
    public String saveAccount(Account account,Model model){
        curdService.saveAccount(account);
        return "redirect:/account/add";
    }


    @RequiresPermissions("permissionAdd")
    @GetMapping("/permission/add")
    public String permissionAdd(){
        return "permission/add";
    }

    @PostMapping("/permission/add")
    public String savePermission(Model model, Permission permission){
        curdService.savePermission(permission);
        return "redirect:/permission/add";
    }

    @GetMapping("/accountRole/add")
    public String accountRoleAdd(){
        return "accountRole/add";
    }

    @PostMapping("/accountRole/add")
    public String saveAccountRole(Model model, AccountRoleKey accountRoleKey){
        curdService.saveAccountRole(accountRoleKey);
        return "redirect:/accountRole/add";
    }

    @GetMapping("/rolePermission/add")
    public String rolePermission(){
        return "rolePermission/add";
    }
    @PostMapping("/rolePermission/add")
    public String saveRolePermission(Model model, RolePermissionKey rolePermissionKey){
        curdService.saveRolePermission(rolePermissionKey);
        return "redirect:/rolePermission/add";
    }
}
