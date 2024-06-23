package com.projet3ocr.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@NoArgsConstructor
@Data
@Table(name="MESSAGES")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(length = 2000)
    private String message;

    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = true)
    private User user;
    @ManyToOne
    @JoinColumn(name="rental_id", nullable = true)
    private Rental rental;
}
