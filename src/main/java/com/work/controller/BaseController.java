package com.work.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BaseController {

    @GetMapping("/error")
    public String show(){
        return "error";
    }

    @GetMapping("/index")
    public ModelAndView index(){
        return new ModelAndView("/index");
    }
}
