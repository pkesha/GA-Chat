package com.ga.chat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "chatmessages")
public class ChatMessage {
    // This will have a column of id, with each new entry being unique
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    @Column
    private String message;

    @Column
    private LocalDate date;

    // There will be many messages to a User
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public ChatMessage(Long id, String message, User user) {
        this.id = id;
        this.message = message;
        this.user = user;
    }

    public ChatMessage(Long id, String message, LocalDate date, User user) {
        this.id = id;
        this.message = message;
        this.date = date;
        this.user = user;
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
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
