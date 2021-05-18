package com.ga.chat.controller;

import com.ga.chat.model.ChatMessage;
import com.ga.chat.repository.UserRepository;
import com.ga.chat.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@RestController
public class ChatMessageController {
    
}
