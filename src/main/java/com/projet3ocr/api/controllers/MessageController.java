package com.projet3ocr.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api/messages")
public class MessageController {

    @PostMapping("/")
   HashMap<String, String> createMessage(){
        HashMap<String, String> response = new HashMap<>();

        return response;
    }
}
