package com.ga.chat.service;

import com.ga.chat.exception.InformationExistsException;
import com.ga.chat.exception.InformationNotFoundException;
import com.ga.chat.model.ChatMessage;
import com.ga.chat.model.User;
import com.ga.chat.repository.*;
import com.ga.chat.security.MyUserDetails;

import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ConversationRepository conversationRepository;
    private final UserRepository userRepository;

    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository, ConversationRepository conversationRepository, UserRepository userRepository) {
        this.chatMessageRepository = chatMessageRepository;
        this.conversationRepository = conversationRepository;
        this.userRepository = userRepository;
    }

    public List<ChatMessage> getMessages() {
        return chatMessageRepository.findAll();
    }

    public ChatMessage addSentMessageToUser(ChatMessage userChatMessage, User sentUser){
        if(userChatMessage.getUser().equals(null)){
            throw new InformationExistsException("User added to ");
        } else {
            userChatMessage.getUser().setId(sentUser.getId());
            return userChatMessage;
        }
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder
        .getContext()
        .getAuthentication()
        .getPrincipal();

        return userDetails.getUser();
    }
}
