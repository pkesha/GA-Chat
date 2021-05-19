package com.ga.chat.service;

import com.ga.chat.exception.InformationNotFoundException;
import com.ga.chat.model.ChatMessage;
import com.ga.chat.model.User;
import com.ga.chat.repository.ChatMessageRepository;
import com.ga.chat.repository.UserRepository;
import com.ga.chat.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final UserRepository userRepository;

    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository, UserRepository userRepository) {
        this.chatMessageRepository = chatMessageRepository;
        this.userRepository = userRepository;
    }

    // -----------------CHAT---------------------- //
    public List<ChatMessage> getMessages() {
        return chatMessageRepository.findAll();
    }

    //Get messages
    public ChatMessage getChatMessage(Long messageId) {
        try{
            return chatMessageRepository.findChatMessageByIdAndUserId(messageId, getUser().getId());
        } catch (Exception e){
            throw new InformationNotFoundException("Message with message id " + messageId + " was not found");
        }
    }

    //  Add/Send messages
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        chatMessage.setUser(getUser());
        return chatMessageRepository.save(chatMessage);
    }

    // Update messages
    public ChatMessage editChatMessage(ChatMessage chatMessage, Long chatId) {
        ChatMessage databaseChatMessage = this.getChatMessage(chatId);
        databaseChatMessage.setMessage(chatMessage.getMessage());
        return chatMessageRepository.save(chatMessage);
    }

    // Will delete for both
    public void deleteChatMessage(Long chatMessageId) {
        this.getChatMessage(chatMessageId);
        chatMessageRepository.deleteById(chatMessageId);
    }


    public User getUser(){
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder
        .getContext()
        .getAuthentication()
        .getPrincipal();

        return userDetails.getUser();
    }
}
