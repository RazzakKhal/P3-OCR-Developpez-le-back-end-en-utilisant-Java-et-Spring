package com.projet3ocr.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @GetMapping("/{id}")
   HashMap<String, String> getUser(@PathVariable Long id){
        HashMap<String, String> response = new HashMap<>();

        return response;
    }
}
