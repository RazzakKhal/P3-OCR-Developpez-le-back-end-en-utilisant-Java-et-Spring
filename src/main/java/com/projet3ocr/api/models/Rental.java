package com.projet3ocr.api.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name="RENTALS")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double surface;

    private Double price;

    private String picture;
    @Column(length = 2000)
    private String description;

    @Column(name = "created_at")
    private Timestamp createdAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne
    @JoinColumn(name="owner_id",nullable = false)
    private User user;
    @OneToMany(mappedBy = "rental")
    private List<Message> messages;


}
