package com.projet3ocr.api.mappers;

import com.projet3ocr.api.dtos.SendMessageDto;
import com.projet3ocr.api.models.Message;
import com.projet3ocr.api.models.Rental;
import com.projet3ocr.api.models.User;

public class MessageMapper {

    public Message toEntity(SendMessageDto sendMessageDto , User user, Rental rental){
        Message message = new Message();
        message.setMessage(sendMessageDto.getMessage());
        message.setUser(user);
        message.setRental(rental);

        return message;
    }
}
