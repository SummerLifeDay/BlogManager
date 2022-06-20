package com.work.controller;

import com.work.pojo.Staff;
import com.work.service.impl.StaffServiceImpl;
import com.work.utils.Log;
import com.work.utils.Message;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StaffController {

    @Autowired
    StaffServiceImpl service;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public ModelAndView login(String userName, String password){
        Log.print(userName + " : " + password);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
            return new ModelAndView("index");
        }catch (UnknownAccountException | IncorrectCredentialsException e){
            return new ModelAndView("login");
        }
    }

    @ResponseBody
    @RequestMapping("/unauth")
    public Object unauth(){
        return new Message(-1, "没有访问权限");
    }

    @ResponseBody
    @RequestMapping(value = "/reg", method = RequestMethod.POST)
    public Object reg(String userName,String password, int role, String nickName){

        if (service.selectOneByName(userName) != null){
            return new Message(-1, "用户已存在");
        }

        if (service.add(new Staff(null, userName, password, role, nickName))){
            return "success";
        }

        return "error";
    }

}
