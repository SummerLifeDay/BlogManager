package com.work.controller;

import com.work.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BaseController {

    @Autowired
    private BaseServiceImpl service;

    @GetMapping("/error")
    public String show(){
        return "error";
    }

    @GetMapping("/index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("/index");
        mav.addObject("countMoney", service.countOrdersMoney());
        mav.addObject("countOrder", service.countOrders());
        mav.addObject("countCustomer", service.countCustomers());
        mav.addObject("countProduct", service.countProducts());
        return mav;
    }
}
