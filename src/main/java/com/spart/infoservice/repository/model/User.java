package com.spart.infoservice.repository.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "users",schema = "general")
@Getter
@Setter
//@ToString(exclude = "medicationEntitySet")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "login",unique = true)
    private String login;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "token")
    private String token;

    @Column(name = "password")
    private String password;
}

