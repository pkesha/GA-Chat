package com.ga.chat.service;

import com.ga.chat.exception.InformationNotFoundException;
import com.ga.chat.model.ChatMessage;
import com.ga.chat.model.User;
import com.ga.chat.repository.ChatMessageRepository;
import com.ga.chat.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.List;


@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private EntityManager entityManager;
    private Object Query;

    @Autowired
    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    // -----------------CHAT---------------------- chatmessages - ChatMessage - ChatMessageController//
    public List<ChatMessage> getMessages() {
        return chatMessageRepository.findAll();
//        List <ChatMessage> list;
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        list = em.createQuery("FROM chatmessages c", ChatMessage.class).getResultList();
//        em.getTransaction().commit();
//        System.out.println(list);

//        List<ChatMessage> foundMessages = chatMessageRepository.findAll();
//        HashMap responseMessage = new HashMap();
//        responseMessage.put("username", getUser().getUserName());
//        responseMessage.put("messages", foundMessages);
//        System.out.println(responseMessage);
//        return responseMessage;
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
//        MyUserDetails myUserDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(getUser().getId());
        chatMessage.setUser(getUser());
//        chatMessage.
        return chatMessageRepository.save(chatMessage);
    }

    // Update messages
    public ChatMessage editChatMessage(ChatMessage chatMessage, Long chatId) {
        ChatMessage databaseChatMessage = this.getChatMessage(chatId);
        databaseChatMessage.setMessage(chatMessage.getMessage());
        return chatMessageRepository.save(databaseChatMessage);
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
