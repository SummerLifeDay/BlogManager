package com.work.controller;

import com.work.model.Customer;
import com.work.service.CusService;
import com.work.service.impl.CusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CusController {

    @Resource
    private CusServiceImpl service;

    @GetMapping("/hello")
    public List<Customer> hello(){
        return service.selectAll();
    }

}
