package com.projet3ocr.api.dtos.receiveFromView;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SendMessageDto {
    @NotBlank
    private String message;
    @JsonProperty("user_id")
    @NotNull
    private Long userId;
    @JsonProperty("rental_id")
    @NotNull
    private Long rentalId;
}
