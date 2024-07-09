package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.LoginUserDto;
import com.projet3ocr.api.dtos.receiveFromView.RegisterUserDto;
import com.projet3ocr.api.dtos.sendToView.UserDto;

import java.util.Map;

public interface AuthService {
    public Map<String, String> createUser(RegisterUserDto registerUserDto);

    public Map<String, String> loginUser(LoginUserDto loginUserDto);

    UserDto getMe(Object principal);
}
