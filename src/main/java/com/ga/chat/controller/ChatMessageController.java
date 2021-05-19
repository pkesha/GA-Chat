package com.ga.chat.controller;

import com.ga.chat.model.ChatMessage;
import com.ga.chat.model.User;
import com.ga.chat.repository.ChatMessageRepository;
import com.ga.chat.security.MyUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;

import antlr.collections.List;

@Controller
public class ChatMessageController {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageController(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessage getMessage(Long messageId) {
        return chatMessageRepository.findChatMessageByIdAndUserId(messageId, getUser().getId());
    }

    public User getUser() {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return userDetails.getUser();
    }

}
