package com.projet3ocr.api.dtos.receiveFromView;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
@Data
public class CreateRentalDto {

     public CreateRentalDto(String name, Double surface, Double price, String description, MultipartFile picture){
        this.name = name;
        this.surface = surface;
        this.price = price;
        this.description = description;
        this.picture = picture;
    }
    @NotBlank
    private String name;
    @NotNull
    private Double surface;
    @NotNull
    private Double price;
    @NotBlank
    private MultipartFile picture;
    @NotBlank
    private String description;

}
