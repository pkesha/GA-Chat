package com.ga.chat.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    // Used to route the message from one client to another in the chat. 
    @Override
    public void configureMessageBroker(MessageBrokerRegistry configure) {
        // will route to the message handling method
        configure.setApplicationDestinationPrefixes("/app");
        
        // '/topic' - enables simple memory based message broker to carry messages back to the
        // client to the destination prefixes set as '/topics'
        configure.enableSimpleBroker("/topics");
    }

    // STOMP - Simple Text Oriented Messaging Protocol
    // Defines rules & format for data exchanging between server and client
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // Define a WebSocket endpoint so that a client will use it to establish a connection 
        // with our WebSocket server
        registry.addEndpoint("/ws").withSockJS();
    }
}
