package com.projet3ocr.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Table(name="USERS",indexes = @Index(name = "USERS_index", columnList = "email"))
@Entity
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    private String password;
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @OneToMany(mappedBy = "user")
    private List<Message> messages;
    @OneToMany(mappedBy = "user")
    private List<Rental> rentals;
}
