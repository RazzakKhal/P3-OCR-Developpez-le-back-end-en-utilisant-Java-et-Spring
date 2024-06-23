package com.projet3ocr.api.dtos;

import lombok.Data;

@Data
public class RegisterUserDto {

    private String name;

    private String email;

    private String password;
}
