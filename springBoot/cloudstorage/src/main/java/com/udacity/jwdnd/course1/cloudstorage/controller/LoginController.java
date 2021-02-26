package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("login")
public class LoginController {

    @GetMapping
    public String loginView(Authentication authentication){

        if(authentication!= null &&!( authentication instanceof AnonymousAuthenticationToken)){
            return "redirect:/home";
        }
        return "login";


    }
}
