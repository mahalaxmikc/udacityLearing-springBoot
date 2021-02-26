package com.udacity.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/firstVisit")
public class FirstVisitController {

    @GetMapping()
    public String firstVisit(Model model) {
        model.addAttribute("firstVisit", true);
        return "firstVisit";
    }

    @PostMapping()
    public String subsequentVisit(Model model) {
        model.addAttribute("firstVisit", false);
        return "firstVisit";
    }



}
