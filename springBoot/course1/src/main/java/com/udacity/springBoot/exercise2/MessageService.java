package com.udacity.springBoot.exercise2;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Service
public class MessageService {

    private  String message;

    public MessageService(String message) {
        this.message = message;
    }

    public String upperCase(){
        return this.message.toUpperCase();
    }

    public String lowerCase(){
        return this.message.toLowerCase();
    }

    @PostConstruct
    public void init(){
        System.out.println("MessageService instantiated");
    }
}
