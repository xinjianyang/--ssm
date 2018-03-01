package com.shanghai.controller.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xinjian on 2018/3/1 0001.
 *
 * @author xinjian
 */

@Component
@Aspect
public class TestAdvice {

    @Pointcut("execution(* com.shanghai.domain.service.impl.TestServiceImpl.add(..)))")
    public void pointcut(){}


    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args =Arrays.asList(joinPoint.getArgs());
        System.out.println("@Before 前置通知 : 方法名 【 " + methodName + " 】and args are " + args);
    }
}
