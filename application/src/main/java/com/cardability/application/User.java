package com.cardability.application;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Table(schema = "cardability", name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "users")
    private Set<Card> cards = new HashSet<>();


    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
