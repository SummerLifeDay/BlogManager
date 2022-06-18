package com.work.controller;

import com.work.pojo.Coupon;
import com.work.service.impl.CouPonServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
public class CouponController {

    @Resource
    private CouPonServiceImpl service;

    @GetMapping("/admin/coupon")
    public String coupon(){
        return "admin/coupon";
    }

    @GetMapping("/admin/coupon/all")
    public ModelAndView selectAll(){
        return new ModelAndView("admin/coupon", "coupons", service.selectAll());
    }

    @PostMapping(value = "/admin/coupon/add")
    public boolean add(double discount, int count, String term){
        return service.add(new Coupon(discount, UUID.randomUUID().toString(), term, count));
    }

    @PostMapping(value = "/admin/coupon/del")
    public boolean del(int dinerNum){
        return service.delete(dinerNum);
    }
}
