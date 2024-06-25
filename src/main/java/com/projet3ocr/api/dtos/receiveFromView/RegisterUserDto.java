package com.projet3ocr.api.dtos.receiveFromView;

import lombok.Data;

@Data
public class RegisterUserDto {

    private String name;

    private String email;

    private String password;
}
