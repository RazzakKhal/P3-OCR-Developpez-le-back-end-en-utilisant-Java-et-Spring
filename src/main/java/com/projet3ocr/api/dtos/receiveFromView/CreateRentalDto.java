package com.projet3ocr.api.dtos.receiveFromView;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class CreateRentalDto {

     public CreateRentalDto(String name, Double surface, Double price, String description){
        this.name = name;
        this.surface = surface;
        this.price = price;
        this.description = description;

    }
    @NotBlank
    private String name;
    @NotNull
    private Double surface;
    @NotNull
    private Double price;
    @NotBlank
    private String description;

}
