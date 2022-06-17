package com.work.controller;

import com.work.pojo.Staff;
import com.work.service.impl.StaffServiceImpl;
import com.work.utils.Log;
import com.work.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public String login(String userName,String password){
        Log.print(userName + " : " + password);
        Staff staff = service.selectOneByName(userName);
        if (staff != null && staff.getPassword().equals(password)){
            return "success";
        }

        return "error";
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
