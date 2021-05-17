package com.ga.chat.controller;

import com.ga.chat.model.ChatMessage;
import com.ga.chat.repository.UserRepository;
import com.ga.chat.service.UserService;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatMessageController {

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, ChatMessage chatMessage){
        System.out.println("handling send message " + chatMessage.toString() + " to: " + to);
        boolean isExists = 
    }
}
