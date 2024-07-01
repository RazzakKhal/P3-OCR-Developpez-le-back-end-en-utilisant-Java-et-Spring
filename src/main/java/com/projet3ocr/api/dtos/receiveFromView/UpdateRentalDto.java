package com.projet3ocr.api.dtos.receiveFromView;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class UpdateRentalDto {
    @NotBlank(message = "il faut entrer un nom")
    private String name;
    @NotNull
    private Double surface;
    @NotNull
    private Double price;
    @NotBlank
    private String description;
}
