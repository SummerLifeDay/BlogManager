package com.work.controller;

import com.work.pojo.Customer;
import com.work.pojo.Product;
import com.work.service.impl.ProServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ProController {

    @Resource
    private ProServiceImpl service;

    @GetMapping("/admin/product")
    public String product(){
        return "admin/product";
    }

    @ResponseBody
    @GetMapping("/admin/product/all")
    public List<Product> selectAll(){
        return service.selectAll();
    }

    @PostMapping(value = "/admin/product/add")
    public boolean add(String pName, int reserve, String imgUrl, double price){
        return service.add(new Product(null, pName, reserve, imgUrl, price));
    }

    @PostMapping(value = "/admin/product/update")
    public boolean update(int pId, String pName, int reserve, String imgUrl, double price){
        return service.edit(new Product(pId, pName, reserve, imgUrl, price));
    }

    @PostMapping(value = "/admin/product/del")
    public boolean del(int pId){
        return service.delete(pId);
    }
}
