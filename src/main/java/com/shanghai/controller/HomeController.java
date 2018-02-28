package com.shanghai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by xinjian on 2018/2/28 0028.
 *
 * @author xinjian
 */
@Controller
public class HomeController {


    @GetMapping("/hello")
    public String hello(){
        return "home";
    }
}
