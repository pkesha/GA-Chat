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
// -----------------CHAT---------------------- //
    public List<ChatMessage> getMessages() {
        return chatMessageRepository.findAll();
    }

    //Add messages
    public ChatMessage getChatMessage(Long messageId) {
        try{
            return chatMessageRepository.findChatMessageByIdAndUserId(messageId, getUser().getId());
        } catch (Exception e){
            throw new InformationNotFoundException("Message with message id " + messageId + " was not found");
        }
    }

    // Update messages
    public ChatMessage editChatMessage(ChatMessage chatMessage, Long chatId) {
        ChatMessage databaseChatMessage = this.getChatMessage(chatId);
        databaseChatMessage.setMessage(chatMessage.getMessage());
        
        return chatMessageRepository.save(chatMessage);
    }

    // Will update for both
    public void deleteChatMessage(Long chatMessageId) {
        this.getChatMessage(chatMessageId);
        chatMessageRepository.deleteById(chatMessageId);
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
