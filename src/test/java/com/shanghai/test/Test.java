package com.shanghai.test;

import com.shanghai.controller.aop.TestAdvice;
import com.shanghai.domain.service.TestService;
import com.shanghai.domain.service.impl.TestServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xinjian on 2018/3/1 0001.
 *
 * @author xinjian
 */


public class Test {


    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        TestService service = (TestService) context.getBean("testServiceImpl");
        service.add(1,99);
        context.close();
    }
}
