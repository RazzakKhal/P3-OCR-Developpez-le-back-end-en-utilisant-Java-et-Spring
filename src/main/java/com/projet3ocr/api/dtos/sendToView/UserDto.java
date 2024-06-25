package com.projet3ocr.api.dtos.sendToView;

import lombok.Data;

import java.sql.Timestamp;
import java.time.Instant;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private Instant createdAt;

    private Instant updatedAt;
}
