package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.SendMessageDto;
import com.projet3ocr.api.mappers.MessageMapper;
import com.projet3ocr.api.models.Rental;
import com.projet3ocr.api.models.User;
import com.projet3ocr.api.repositories.MessageRepository;
import com.projet3ocr.api.repositories.RentalRepository;
import com.projet3ocr.api.repositories.UserRepository;
import com.projet3ocr.api.responses.MessagesResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    MessageRepository messageRepository;
    @Autowired
    MessageMapper messageMapper;
    @Override
    public HashMap<String, String> postMessage(SendMessageDto sendMessageDto){
        HashMap<String, String> response = new HashMap<>();

        Optional<User> optUser = userRepository.findById(sendMessageDto.getUserId());
        Optional<Rental> optRental = rentalRepository.findById(sendMessageDto.getRentalId());

        if(optRental.isEmpty() || optUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "l'utilisateur ou la location ne semble pas exister");
        }

        messageRepository.save(messageMapper.toEntity(sendMessageDto, optUser.get(), optRental.get()));
        response.put("message", MessagesResponses.SENDED_MESSAGE.getValue());
        return response;
    }
}
