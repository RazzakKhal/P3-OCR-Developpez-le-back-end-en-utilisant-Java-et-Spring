package com.projet3ocr.api.dtos;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Timestamp createdAt;

    private Timestamp updatedAt;
}
