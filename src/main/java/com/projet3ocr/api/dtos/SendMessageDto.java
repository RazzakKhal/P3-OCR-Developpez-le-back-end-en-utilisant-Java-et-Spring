package com.projet3ocr.api.dtos;

import lombok.Data;

@Data
public class SendMessageDto {

    private String message;

    private Long ownerId;

    private Long rentalId;
}
