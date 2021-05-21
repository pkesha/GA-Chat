package com.ga.chat.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;

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
    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

//    @ManyToOne
//    @JsonIgnore
//    @JoinColumn(name="user_name")
//    private Long user.

    public ChatMessage(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public ChatMessage(Long id, String message, LocalDate date) {
        this.id = id;
        this.message = message;
        this.date = date;
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
