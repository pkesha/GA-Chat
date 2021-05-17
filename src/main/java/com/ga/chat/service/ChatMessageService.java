package com.ga.chat.service;

import com.ga.chat.model.User;
import com.ga.chat.repository.*;
import org.jboss.logging.Messages;
import org.springframework.beans.factory.annotation.Autowired;
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

//    public User getUser() {
//
//    }

    /***************ChatMessages**************/
//    public List<Messages> getMessages
}
