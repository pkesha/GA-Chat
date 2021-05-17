package com.ga.chat.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry configure) {
        // '/topic' - enables simple memory based message broker to carry messages back to the
        // client to the destination prefixes set as '/topic'
        configure.enableSimpleBroker("/topic");

        // should this be api instead of app?
        configure.setApplicationDestinationPrefixes("/app");
    }


    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // Will broadcast to all?
        registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
        registry.addEndpoint("/chat").withSockJS();
    }
}
