package com.shanghai.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by xinjian on 2018/3/2 0002.
 *
 * @author xinjian
 */
public class BaseController {

    @ExceptionHandler(UnauthorizedException.class)
    public String exceptionHandler(UnauthorizedException ex){
        System.out.println(ex.getMessage()+"---------------------------------");
        return "error";
    }
}
