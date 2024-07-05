package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.SendMessageDto;

import java.util.HashMap;
import java.util.Map;

public interface MessageService {

    Map<String, String> postMessage(SendMessageDto sendMessageDto);
}
