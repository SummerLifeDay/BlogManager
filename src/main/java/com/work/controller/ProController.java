package com.work.controller;

import com.work.pojo.Customer;
import com.work.pojo.Product;
import com.work.service.impl.ProServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProController {

    @Resource
    private ProServiceImpl service;

    @GetMapping("/admin/product")
    public String product(){
        return "redirect:/admin/product/all";
    }

    @GetMapping("/admin/product/index")
    public String toIndex(){
        return "/admin/product/index";
    }

    @ResponseBody
    @GetMapping("/admin/product/all")
    public ModelAndView selectAll(){
        return new ModelAndView(toIndex(), "products", service.selectAll());
    }

    @PostMapping(value = "/admin/product/add")
    public ModelAndView add(String pName, int reserve, String imgUrl, double price){
        service.add(new Product(null, pName, reserve, imgUrl, price));
        return selectAll();
    }

    @PostMapping(value = "/admin/product/update")
    public ModelAndView update(int pId, String pName, int reserve, String imgUrl, double price){
        service.edit(new Product(pId, pName, reserve, imgUrl, price));
        return selectAll();
    }

    @PostMapping(value = "/admin/product/del")
    public ModelAndView del(int pId){
        System.out.println(pId);
        service.delete(pId);
        return selectAll();
    }

    @GetMapping(value = "/admin/product/count")
    public ModelAndView count( ){
        return null;
    }
}
