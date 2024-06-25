package com.projet3ocr.api.dtos.sendToView;
import lombok.Data;
import java.sql.Timestamp;
import java.time.Instant;

@Data
public class RentalDto {
    private Long id;
    private String name;
    private Double surface;
    private Double price;
    private String picture;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private Long ownerId;

}
