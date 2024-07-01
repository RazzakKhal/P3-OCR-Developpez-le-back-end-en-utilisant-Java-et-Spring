package com.projet3ocr.api.controllers;

import com.projet3ocr.api.dtos.receiveFromView.LoginUserDto;
import com.projet3ocr.api.dtos.receiveFromView.RegisterUserDto;
import com.projet3ocr.api.dtos.sendToView.UserDto;
import com.projet3ocr.api.models.User;
import com.projet3ocr.api.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    @PostMapping("/register")
    HashMap<String, String> registerAnUser(@Valid @RequestBody RegisterUserDto registerUserDto){
        return authService.createUser(registerUserDto);
    }

    @PostMapping("/login")
    HashMap<String, String> loginAnUser(@Valid @RequestBody LoginUserDto loginUserDto){
        return authService.loginUser(loginUserDto);
    }

    @GetMapping("/me")
    UserDto getAnUser(Authentication authentication){
        return authService.getMe(authentication.getPrincipal());
    }
}
