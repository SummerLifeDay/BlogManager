package com.work.controller;

import com.work.pojo.Order;
import com.work.pojo.Table;
import com.work.service.impl.TableServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Controller
public class TableController {

    @Resource
    private TableServiceImpl service;

    @GetMapping("/admin/table")
    public String product(){
        return "admin/table";
    }

    @ResponseBody
    @GetMapping("/admin/table/all")
    public List<Table> selectAll(){
        return service.selectAll();
    }

    @PostMapping(value = "/admin/table/add")
    public int add(int isFree, int totalNum, int isBox){
        return service.add(new Table(null, isFree, totalNum, isBox));
    }

    @PostMapping(value = "/admin/table/update")
    public int update(int dinerNum, int isFree, int totalNum, int isBox){
        return service.edit(new Table(dinerNum, isFree, totalNum, isBox));
    }

    @PostMapping(value = "/admin/table/updateState")
    public int updateState(int dinerNum, int isFree){
        return service.updateState(dinerNum, isFree);
    }

    @PostMapping(value = "/admin/table/del")
    public int del(int dinerNum){
        return service.delete(dinerNum);
    }
}
