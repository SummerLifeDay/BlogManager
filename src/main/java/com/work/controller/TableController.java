package com.work.controller;

import com.work.pojo.Tables;
import com.work.service.impl.TableServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class TableController {

    @Resource
    private TableServiceImpl service;

    @GetMapping("/admin/table")
    public String product(){
        return "redirect:/admin/table/all";
    }

    @GetMapping("/admin/table/index")
    public String toIndex(){
        return "/admin/table/index";
    }

    @ResponseBody
    @GetMapping("/admin/table/all")
    public ModelAndView selectAll(){
        return new ModelAndView(toIndex(), "tables", service.selectAll());
    }

    @PostMapping(value = "/admin/table/add")
    public ModelAndView add(int isFree, int totalNum, int isBox){
        service.add(new Tables(null, isFree, totalNum, isBox));
        return selectAll();
    }

    @PostMapping(value = "/admin/table/update")
    public ModelAndView update(int dinerNum, int isFree, int totalNum, int isBox){
        service.edit(new Tables(dinerNum, isFree, totalNum, isBox));
        return selectAll();
    }

    @PostMapping(value = "/admin/table/updateState")
    public ModelAndView updateState(int dinerNum, int isFree){
        service.updateState(dinerNum, isFree);
        return selectAll();
    }

    @PostMapping(value = "/admin/table/del")
    public ModelAndView del(int dinerNum){
        service.delete(dinerNum);
        return selectAll();
    }
}
