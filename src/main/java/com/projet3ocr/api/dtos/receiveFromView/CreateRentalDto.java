package com.projet3ocr.api.dtos.receiveFromView;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class CreateRentalDto {

    private String name;
    private Double surface;
    private Double price;
    private String picture;
    private String description;

}
