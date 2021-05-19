package com.ga.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "chatmessages")
public class ChatMessage {

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }


    // This will have a column of id, with each new entry being unique
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
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

    private MessageType messageType;

    public ChatMessage(Long id, String message, User user, MessageType messageType) {
        this.id = id;
        this.message = message;
        this.user = user;
        this.messageType = messageType;
    }

    public ChatMessage(MessageType messageType) {
        this.messageType = messageType;
    }


    public ChatMessage(Long id, String message, String fromLogin, LocalDate date) {
        this.id = id;
        this.message = message;
        this.fromLogin = fromLogin;
        this.date = date;
    }

    public ChatMessage(Long id, String message, String fromLogin, LocalDate date, User user) {
        this.id = id;
        this.message = message;
        this.fromLogin = fromLogin;
        this.date = date;
        this.user = user;
    }

    //Default Constructor
    public ChatMessage() {

    }


    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
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


    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", fromLogin='" + fromLogin + '\'' +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
