package com.ga.chat.controller;

import com.ga.chat.model.ChatMessage;
import com.ga.chat.model.User;
import com.ga.chat.model.request.LoginRequest;
import com.ga.chat.service.ChatMessageService;
import com.ga.chat.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/users")
public class UserController {
    private final UserService userService;
    private final ChatMessageService chatMessageService;
    private ChatMessage chatMessageIntro;

    public UserController(UserService userService, ChatMessageService chatMessageService) {
        this.userService = userService;
        this.chatMessageService = chatMessageService;
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User userInput) {
        User newUser = this.userService.createUser(userInput);
        //chatMessageIntro.setUser(newUser);
        return newUser;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest){
        // chatMessageIntro.setMessage(chatMessageIntro.getUser().getUserName() + " has entered the chat");
        // chatMessageService.sendMessage(chatMessageIntro);
        return userService.loginUser(loginRequest);
    }
}