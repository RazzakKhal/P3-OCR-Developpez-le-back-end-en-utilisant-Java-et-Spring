package com.projet3ocr.api.dtos.receiveFromView;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SendMessageDto {

    private String message;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("rental_id")
    private Long rentalId;
}
