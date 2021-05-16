package com.ga.chat.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFromLogin() {
        return fromLogin;
    }

    public void setFromLogin(String fromLogin) {
        this.fromLogin = fromLogin;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", fromLogin='" + fromLogin + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", conversation=" + conversation +
                '}';
    }
}
