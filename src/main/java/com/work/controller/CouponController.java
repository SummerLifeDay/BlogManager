package com.work.controller;

import com.work.pojo.Coupon;
import com.work.service.impl.CouPonServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.UUID;

@Controller
public class CouponController {

    @Resource
    private CouPonServiceImpl service;

    @GetMapping("/admin/coupon")
    public String coupon(){
        return "redirect:/admin/coupon/all";
    }

    @GetMapping("/admin/coupon/index")
    public String toIndex(){
        return "/admin/coupon/index";
    }

    @GetMapping("/admin/coupon/all")
    public ModelAndView selectAll(){
        return new ModelAndView(toIndex(), "coupons", service.selectAll());
    }

    @PostMapping(value = "/admin/coupon/add")
    public ModelAndView add(double discount, int count, String term){
        service.add(new Coupon(UUID.randomUUID().toString(), discount,  term, count));
        return selectAll();
    }

    @PostMapping(value = "/admin/coupon/del")
    public ModelAndView del(String couponNum){
        service.delete(couponNum);
        return selectAll();
    }
}
