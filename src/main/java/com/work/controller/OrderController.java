package com.work.controller;

import com.work.pojo.Orders;
import com.work.service.impl.OrderServiceImpl;
import com.work.service.impl.ProServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.UUID;

@Controller
public class OrderController {

    @Resource
    private OrderServiceImpl service;
    @Resource
    private ProServiceImpl proService;

    @GetMapping("/admin/order")
    public String product(){
        return "redirect:/admin/order/all";
    }

    @GetMapping("/admin/order/index")
    public String toIndex(){
        return "/admin/order/index";
    }

    @ResponseBody
    @GetMapping("/admin/order/all")
    public ModelAndView selectAll(){
        ModelAndView mav = new ModelAndView(toIndex());
        mav.addObject("orders", service.selectAll());
        mav.addObject("pros", proService.selectAll());
        return mav;
    }


    @PostMapping(value = "/admin/order/add")
    public ModelAndView add(String customer, double price, int useCoupon, int useTable){
        service.add(new Orders(UUID.randomUUID().toString(), customer, price, useCoupon, useTable));
        return selectAll();
    }

    @PostMapping(value = "/admin/order/update")
    public ModelAndView update(String orderNum, String customer, double price, int useCoupon, int useTable){
        service.edit(new Orders(orderNum, customer, price, useCoupon, useTable));
        return selectAll();
    }

    @PostMapping(value = "/admin/order/del")
    public ModelAndView del(String orderNum){
        service.delete(orderNum);
        return selectAll();
    }
}
