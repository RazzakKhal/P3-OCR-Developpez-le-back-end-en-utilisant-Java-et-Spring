package com.projet3ocr.api.controllers;

import com.projet3ocr.api.dtos.receiveFromView.SendMessageDto;
import com.projet3ocr.api.services.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@CrossOrigin
@RestController
@RequestMapping("api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("")
   HashMap<String, String> createMessage(@Valid @RequestBody SendMessageDto sendMessageDto){
        return messageService.postMessage(sendMessageDto);
    }
}
