package com.projet3ocr.api.dtos.receiveFromView;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUserDto {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
