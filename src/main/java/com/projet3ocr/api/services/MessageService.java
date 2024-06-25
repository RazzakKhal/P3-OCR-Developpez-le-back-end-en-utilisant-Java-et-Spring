package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.SendMessageDto;

import java.util.HashMap;

public interface MessageService {

    HashMap<String, String> postMessage(SendMessageDto sendMessageDto);
}
