package com.ga.chat.model;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name="conversations")
public class Conversation {

    //@GeneratedValue(strategy = GenerationType.IDENTITY);
    @Id
    @Column
    private Long id;

    // There will only be two users
    // Look how to do many to many
    @JsonIgnore
    @ManyToMany
    @JoinColumn(name="user_id")
    private List<User> userList;

    @JsonIgnore
    @OneToMany(mappedBy = "conversation")
    private List<ChatMessage> messageList;

    public Conversation() {

    }

    public Conversation(Long id, List<User> userList, List<ChatMessage> messageList) {
        this.id = id;
        this.userList = userList;
        this.messageList = messageList;
    }
}
