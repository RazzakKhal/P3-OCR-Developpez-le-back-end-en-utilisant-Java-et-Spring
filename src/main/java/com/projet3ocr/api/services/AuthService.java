package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.LoginUserDto;
import com.projet3ocr.api.dtos.receiveFromView.RegisterUserDto;
import com.projet3ocr.api.dtos.sendToView.UserDto;
import com.projet3ocr.api.models.User;

import java.security.Principal;
import java.util.HashMap;

public interface AuthService {
    public HashMap<String, String> createUser(RegisterUserDto registerUserDto);

    public HashMap<String, String> loginUser(LoginUserDto loginUserDto);

    UserDto getMe(Object principal);
}
