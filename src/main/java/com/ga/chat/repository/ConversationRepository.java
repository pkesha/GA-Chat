package com.ga.chat.repository;

import com.ga.chat.model.Conversation;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    Conversation findByIdAndUserId(Long conversationId, Long userId);

    List<Conversation> findAllByUserId(Long userId);
}
