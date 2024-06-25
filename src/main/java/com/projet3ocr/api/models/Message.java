package com.projet3ocr.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SourceType;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.Instant;


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
    @CreationTimestamp(source = SourceType.DB)
    private Instant createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp(source = SourceType.DB)
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = true)
    private User user;
    @ManyToOne
    @JoinColumn(name="rental_id", nullable = true)
    private Rental rental;
}
