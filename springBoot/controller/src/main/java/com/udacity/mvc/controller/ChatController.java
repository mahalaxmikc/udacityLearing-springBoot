package com.udacity.mvc.controller;

import com.udacity.mvc.model.ChatForm;
import com.udacity.mvc.service.MessageListService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {
    private MessageListService messageListService;

    public ChatController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping
    public String displayChatPage(@ModelAttribute("newChat") ChatForm chatForm, Model model){
        return "chat";
    }

    @PostMapping
    public String addChatMessages(@ModelAttribute("newChat") ChatForm chatForm, Authentication authentication, Model model){
        chatForm.setUserName(authentication.getName());
        messageListService.addChatMessages(chatForm);
        model.addAttribute("chatMessages", this.messageListService.getChatMessages());
        return "chat";
    }
}
