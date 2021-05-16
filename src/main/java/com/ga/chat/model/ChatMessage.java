package com.ga.chat.model;

import java.time.LocalDate;
import javax.persistence.*;
import com.ga.chat.model.Conversation;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "chatmessages")
public class ChatMessage {


    // This will have a column of id, with each new entry being unique
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private Long id;

    @Column
    private String message;

    @Column
    private String fromLogin;

    @Column
    private LocalDate date;

    // There will be many messages to a User
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    // Many messages to a conversation
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="conversation_id");
    private Conversation conversation;

    public ChatMessage(Long id, String message, String fromLogin, LocalDate date) {
        this.id = id;
        this.message = message;
        this.fromLogin = fromLogin;
        this.date = date;
    }

    public ChatMessage(Long id, String message, String fromLogin, LocalDate date, User user,
    Conversation conversation) {
        this.id = id;
        this.message = message;
        this.fromLogin = fromLogin;
        this.date = date;
        this.user = user;
        this.conversation = conversation;
    }

    //Default Constructor
    public ChatMessage() {

    }
}
