package com.work.controller;

import com.work.pojo.Coupon;
import com.work.service.impl.CouPonServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @ResponseBody
    @GetMapping("/admin/coupon/all")
    public List<Coupon> selectAll(){
        return service.selectAll();
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
