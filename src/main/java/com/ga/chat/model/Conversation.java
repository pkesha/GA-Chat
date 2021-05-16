package com.ga.chat.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name="conversations")
public class Conversation {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Long id;

    // There will only be two users
    @JsonIgnore
    @ManyToMany
    @JoinColumn(name="user_id")
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "conversation")
    private List<ChatMessage> messageList;
}
