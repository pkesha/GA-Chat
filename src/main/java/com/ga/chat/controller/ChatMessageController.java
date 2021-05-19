package com.ga.chat.controller;

import java.util.List;

import com.ga.chat.model.ChatMessage;
import com.ga.chat.model.User;
import com.ga.chat.repository.ChatMessageRepository;
import com.ga.chat.security.MyUserDetails;
import com.ga.chat.service.ChatMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(path = "/api")
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @Autowired
    public ChatMessageController(ChatMessageService chatMessageService) {
        this.chatMessageService = chatMessageService;
    }

    @GetMapping("/chatmessages") 
    public List<ChatMessage> getChatMessages() {
        return chatMessageService.getMessages();
    }

    @GetMapping("/chatmessages/{chatmessageId}")
    public ChatMessage getChatMessage(@PathVariable Long chatMessageId) {
        return chatMessageService.getChatMessage(chatMessageId);
    }

    @PostMapping("/chatmessages")
    public ResponseEntity<ChatMessage> sendChatMessage(@RequestBody ChatMessage chatMessage) {
        return new ResponseEntity<>(chatMessageService.sendMessage(chatMessage), HttpStatus.CREATED);
    }

    @PutMapping("/chatmessages/{chatMessageId}")
    public ResponseEntity<ChatMessage> updateChatMessage(@PathVariable long chatMessageId, 
    @RequestBody ChatMessage chatMessage) {
        return new ResponseEntity<>(chatMessageService.updateChatMessage(chatMessage, chatMessageId), 
        HttpStatus.OK);
    }

    @DeleteMapping("/chatmessages/{chatMessageId}")
    public HttpStatus deleteChatMessage(@PathVariable Long chatMessageId){
        chatMessageService.deleteChatMessage(chatMessageId);
        return HttpStatus.OK;
    }
}
