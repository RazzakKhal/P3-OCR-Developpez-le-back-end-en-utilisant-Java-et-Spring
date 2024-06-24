package com.projet3ocr.api.controllers;

import com.projet3ocr.api.dtos.SendMessageDto;
import com.projet3ocr.api.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/")
   HashMap<String, String> createMessage(@RequestBody SendMessageDto sendMessageDto){
        return messageService.postMessage(sendMessageDto);
    }
}
