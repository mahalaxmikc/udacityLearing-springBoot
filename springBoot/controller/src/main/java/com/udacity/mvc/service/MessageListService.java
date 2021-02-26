package com.udacity.mvc.service;

import com.udacity.mvc.mapper.MessageMapper;
import com.udacity.mvc.model.ChatForm;
import com.udacity.mvc.model.ChatMessage;
import com.udacity.mvc.model.MesageType;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {


    private MessageMapper messageMapper;

    public MessageListService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @PostConstruct
    public void initalizeMessageList(){
        System.out.println("Creating MessageService bean");
    }

    public  void addChatMessages(ChatForm chatForm){

        ChatMessage newChatMessage =  new ChatMessage();
        newChatMessage.setUserName(chatForm.getUserName());

        switch (chatForm.getMesageType()){

            case Say:
                newChatMessage.setMessageText(chatForm.getMessageText());
                break;

            case Shout:

                newChatMessage.setMessageText(chatForm.getMessageText().toUpperCase());
                break;

            case Whisper:

                newChatMessage.setMessageText(chatForm.getMessageText().toLowerCase());
                break;


        }
    this.messageMapper.addMessage(newChatMessage);

    }

    public List<ChatMessage> getChatMessages(){
        return (this. messageMapper.getAllMessages());
    }
}
