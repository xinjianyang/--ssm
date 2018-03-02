package com.shanghai.controller.aop;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by xinjian on 2018/3/2 0002.
 * controllerAdvice 为解决控制器异常的一种很spring的方案,
 * 另外一个方案是创建所有controller的基类,处理,异曲同工,不过还是spring的好用,可以打印异常信息
 * 上面两种方案都可以实现异常注入,打印异常信息
 * @author xinjian
 */

//@ControllerAdvice
public class AppWideExceptionHandler {


    @ExceptionHandler(UnauthorizedException.class)
    public String unauthorizedExceptionHandler(UnauthorizedException ex){
        System.out.println(ex.getMessage() + "---------------------------");
        System.out.println(ex.getStackTrace() + "---------------------------");
        System.out.println("-----------------------------------------------");
        ex.printStackTrace();
        System.out.println("-----------------------------------------------");
        return "error";
    }


}
