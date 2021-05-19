package com.ga.chat.repository;

import com.ga.chat.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    ChatMessage findChatMessageByIdAndUserId(Long chatId, Long userId);

    List<ChatMessage> findAllByUserId(Long userId);
}
