package com.example.billmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    @GetMapping
    public ModelAndView showHome() {
        ModelAndView model = new ModelAndView("home");
        return model;
    }
    @GetMapping("/test")
    public ModelAndView test() {
        ModelAndView model = new ModelAndView("TEST");
        return model;
    }
}
