package com.projet3ocr.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    HashMap<String, String> registerAnUser(){
        HashMap<String, String> response = new HashMap<>();

        return response;
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
