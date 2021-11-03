package com.example.jpa.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    @Size(min = 7)
    @Column(length = 15, nullable = false, unique = true)
    private String phoneNumber;
}
