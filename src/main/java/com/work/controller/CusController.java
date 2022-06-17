package com.work.controller;

import com.work.pojo.Customer;
import com.work.service.impl.CusServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class CusController {

    @Resource
    private CusServiceImpl service;

    @GetMapping("/admin/customer")
    public String customer(){
        return "admin/customer";
    }

    @ResponseBody
    @GetMapping("/admin/customer/all")
    public List<Customer> selectAll(){
        return service.selectAll();
    }

    @PostMapping(value = "/admin/customer/add")
    public boolean add(String userName, String telNum, String birthday){
        return service.add(new Customer(null, userName, telNum, 0, birthday));
    }

    @PostMapping(value = "/admin/customer/update")
    public boolean update(int userId, String userName, String telNum,int integral, String birthday){
        return service.edit(new Customer(userId, userName, telNum, integral, birthday));
    }

    @PostMapping(value = "/admin/customer/del")
    public boolean del(int userId){
        return service.delete(userId);
    }
}
