package com.work.controller;

import com.work.pojo.Order;
import com.work.service.impl.OrderServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
public class OrderController {

    @Resource
    private OrderServiceImpl service;

    @GetMapping("/admin/order")
    public String product(){
        return "admin/order";
    }

    @ResponseBody
    @GetMapping("/admin/order/all")
    public List<Order> selectAll(){
        return service.selectAll();
    }

    @PostMapping(value = "/admin/order/add")
    public boolean add(String customer, double price, int useCoupon, int useTable){
        return service.add(new Order(UUID.randomUUID().toString(), customer, price, useCoupon, useTable));
    }

    @PostMapping(value = "/admin/order/update")
    public boolean update(String orderNum, String customer, double price, int useCoupon, int useTable){
        return service.edit(new Order(orderNum, customer, price, useCoupon, useTable));
    }

    @PostMapping(value = "/admin/order/del")
    public boolean del(String orderNum){
        return service.delete(orderNum);
    }
}
