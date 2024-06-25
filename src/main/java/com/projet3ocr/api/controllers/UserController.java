package com.projet3ocr.api.controllers;

import com.projet3ocr.api.dtos.sendToView.UserDto;
import com.projet3ocr.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    UserDto getUser(@PathVariable Long id) {
        return userService.getOneUser(id);
    }

}
