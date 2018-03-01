package com.shanghai.controller.aop;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by xinjian on 2018/3/1 0001.
 *
 * @author xinjian
 */
@Component
@Aspect
public class CurdAop {

    //private Subject subject = SecurityUtils.getSubject();


    @Pointcut("execution(* com.shanghai.controller.CurdController.accountAdd(..))")
    private void pointcut(){}

    @Before("pointcut()")
    public void beforeMethod(){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>前置通知执行>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        subject.checkRole("admin");

    }
}
