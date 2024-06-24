package com.projet3ocr.api.dtos;
import lombok.Data;
import java.sql.Timestamp;

@Data
public class RentalDto {
    private Long id;
    private String name;
    private Double surface;
    private Double price;
    private String picture;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Long ownerId;

}
