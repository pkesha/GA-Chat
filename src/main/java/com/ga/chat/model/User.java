package com.ga.chat.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<ChatMessage> messageList;

    @OneToMany(mappedBy = "user")
    private List<Conversation> conversationList;


    public User() {
    }

    public User(Long id, String firstName, String lastName, List<ChatMessage> messageList,
                List<Conversation> conversationList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.messageList = messageList;
        this.conversationList = conversationList;
    }

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
