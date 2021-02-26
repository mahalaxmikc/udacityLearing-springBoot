package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/signup")
public class SignUpController {

    private UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String signUpView(@ModelAttribute("user") User user, Model model, Authentication authentication){
        if(authentication!= null &&!( authentication instanceof AnonymousAuthenticationToken)){
            return "redirect:/home";
        }

        return  "signup";
    }


    @PostMapping
    public String signUpUser(@ModelAttribute("user") User user, Model model){
        System.out.println("inside signup");
        int returnUserID;
        boolean errorSignUp= false;
        if(user != null){

            if(!userService.isUsernameAvailable(user.getUsername())) {
                errorSignUp = true;
                System.out.println("duplicate user");
            }else {
                returnUserID = userService.createUser(user);
                System.out.println(returnUserID+"-----------------------------");
                if (returnUserID <= 0)
                 errorSignUp= true;

             }
            if (errorSignUp)
                model.addAttribute("errorSignUp","Error SigningUp");
            else{
                model.addAttribute("successSignUp","SuccessFully SignUp ,Please click here to Login  ");
            }
        }
        return  "signup";
    }


}
