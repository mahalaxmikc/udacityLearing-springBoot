package com.udacity.mvc.controller;

import com.udacity.mvc.model.MessageForm;
import com.udacity.mvc.service.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HelloController {

    private MessageListService messageListService;

    public HelloController (MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping
    public String greetings(@ModelAttribute("newMessage") MessageForm messageForm, Model model){
        model.addAttribute("greetings",  this.messageListService.getChatMessages());
        return "hello";
    }

    @PostMapping
    public String addMessage(@ModelAttribute("newMessage") MessageForm messageForm,Model model){

          // messageListService.addChatMessages(messageForm.getText());
            model.addAttribute("greetings", this.messageListService.getChatMessages());

        return "hello";
    }


}
