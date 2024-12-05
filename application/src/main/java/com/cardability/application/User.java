package com.cardability.application;

import jakarta.persistence.*;

@Table(schema = "User")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    String username;

    String password;
}
