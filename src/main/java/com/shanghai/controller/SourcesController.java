package com.shanghai.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by xinjian on 2018/2/28 0028.
 *
 * @author xinjian
 */

@Controller
public class SourcesController {


    @GetMapping("/get/list")
    @ResponseBody
    //@RequiresRoles("admin")
    public String getList(){
        return "您访问到了一个list";
    }

    @GetMapping("/get/object")
    @ResponseBody
    //@RequiresPermissions(value = "select")
    public String getObject(){
        return "您访问到了一个对象object";
    }
}
