package com.work.controller;

import com.work.pojo.Order;
import com.work.service.impl.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {

    @Resource
    private OrderServiceImpl service;

    @GetMapping("/admin/order")
    public String product(){
        return "redirect:/admin/order/all";
    }

    @GetMapping("/admin/order/index")
    public String toIndex(){
        return "/admin/customer/index";
    }

    @ResponseBody
    @GetMapping("/admin/order/all")
    public ModelAndView selectAll(){
        return new ModelAndView(toIndex(), "orders", service.selectAll());
    }

    @PostMapping(value = "/admin/order/add")
    public ModelAndView add(String customer, double price, int useCoupon, int useTable){
        service.add(new Order(UUID.randomUUID().toString(), customer, price, useCoupon, useTable));
        return selectAll();
    }

    @PostMapping(value = "/admin/order/update")
    public ModelAndView update(String orderNum, String customer, double price, int useCoupon, int useTable){
        service.edit(new Order(orderNum, customer, price, useCoupon, useTable));
        return selectAll();
    }

    @PostMapping(value = "/admin/order/del")
    public ModelAndView del(String orderNum){
        service.delete(orderNum);
        return selectAll();
    }
}
