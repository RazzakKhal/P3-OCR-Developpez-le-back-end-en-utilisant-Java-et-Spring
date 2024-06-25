package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.LoginUserDto;
import com.projet3ocr.api.dtos.receiveFromView.RegisterUserDto;
import com.projet3ocr.api.models.User;

public interface AuthService {
    public User createUser(RegisterUserDto registerUserDto);

    public User loginUser(LoginUserDto loginUserDto);
}
