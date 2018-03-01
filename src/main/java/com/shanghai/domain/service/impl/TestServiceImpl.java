package com.shanghai.domain.service.impl;

import com.shanghai.domain.service.TestService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * Created by xinjian on 2018/3/1 0001.
 *
 * @author xinjian
 */
@Service
public class TestServiceImpl implements TestService {


    @Override
    public int add(int a, int b) {
        System.out.println("------------------add方法执行了----------------------------");
        Subject subject = SecurityUtils.getSubject();
        subject.checkRole("admin");
        return a + b;
    }
}
