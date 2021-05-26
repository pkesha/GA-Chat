package com.ga.chat.controller;

import com.ga.chat.exception.InvalidInputException;
import com.ga.chat.model.ChatMessage;
import com.ga.chat.service.ChatMessageService;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ChatMessageController {
    private final Bucket bucket;
    private final ChatMessageService chatMessageService;

    @Autowired
    public ChatMessageController(ChatMessageService chatMessageService) {
        // Adding Bandwidth limit - 20 requests per minute
        Bandwidth limit = Bandwidth.classic(20, Refill.greedy(20,
                Duration.ofMinutes(1)));

        this.bucket = Bucket4j.builder()
                .addLimit(limit)
                .build();

        this.chatMessageService = chatMessageService;
    }

    @GetMapping("/chatmessages")
    public List<ChatMessage> getChatMessages() {
        System.out.println(chatMessageService.getMessages());
        return chatMessageService.getMessages();
    }

    @GetMapping("/chatmessages/{chatMessageId}")
    public ChatMessage getChatMessage(@PathVariable Long chatMessageId) {
        return chatMessageService.getChatMessage(chatMessageId);
    }

    @PostMapping("/chatmessages")
    public ResponseEntity<ChatMessage> sendChatMessage(@RequestBody ChatMessage chatMessage) throws InvalidInputException {
        if(bucket.tryConsume(1)){
            return new ResponseEntity<>(chatMessageService.sendMessage(chatMessage), HttpStatus.CREATED);
        } else {
            // If there are too many requests, send a 429
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        }
    }

    @PutMapping("/chatmessages/{chatMessageId}")
    public ResponseEntity<ChatMessage> updateChatMessage(@PathVariable long chatMessageId,
    @RequestBody ChatMessage chatMessage) {
        return new ResponseEntity<>(chatMessageService.editChatMessage(chatMessage, chatMessageId),
        HttpStatus.OK);
    }

    @DeleteMapping("/chatmessages/{chatMessageId}")
    public HttpStatus deleteChatMessage(@PathVariable Long chatMessageId){
        chatMessageService.deleteChatMessage(chatMessageId);
        return HttpStatus.OK;
    }
}
