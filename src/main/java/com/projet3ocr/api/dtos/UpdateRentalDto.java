package com.projet3ocr.api.dtos;

import lombok.Data;

@Data
public class UpdateRentalDto {
    private String name;
    private Double surface;
    private Double price;
    private String description;
}
