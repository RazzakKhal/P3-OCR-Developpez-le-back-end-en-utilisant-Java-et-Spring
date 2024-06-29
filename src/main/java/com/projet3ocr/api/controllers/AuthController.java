package com.projet3ocr.api.controllers;

import com.projet3ocr.api.dtos.receiveFromView.RegisterUserDto;
import com.projet3ocr.api.models.User;
import com.projet3ocr.api.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;
    @PostMapping("/register")
    User registerAnUser(@Valid @RequestBody RegisterUserDto registerUserDto){
        return authService.createUser(registerUserDto);
    }

    @PostMapping("/login")
    HashMap<String, String> loginAnUser(){
        HashMap<String, String> response = new HashMap<>();

        return response;
    }

    @GetMapping("/me")
    HashMap<String, String> getAnUser(){
        HashMap<String, String> response = new HashMap<>();

        return response;
    }
}
