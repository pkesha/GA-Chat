package com.ga.chat.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name="conversations")
public class Conversation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    private Long id;

    // There will only be two users
    // How to do many to many?
    // There should be a max of 2
    // Each user in the list should be unique--
    @JsonIgnore
    @ManyToMany
    @JoinColumn(name="user_id")
    private List<User> userList;

    @JsonIgnore
    @OneToMany(mappedBy="conversations")
    private List<ChatMessage> messageList;

    public Conversation() {

    }

    public Conversation(Long id, List<User> userList, List<ChatMessage> messageList) {
        this.id = id;
        this.userList = userList;
        this.messageList = messageList;
    }
}
