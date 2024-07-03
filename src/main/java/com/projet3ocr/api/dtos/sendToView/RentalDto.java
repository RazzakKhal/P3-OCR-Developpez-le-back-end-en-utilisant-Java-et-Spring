package com.projet3ocr.api.dtos.sendToView;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.Instant;

@Data
public class RentalDto implements SendedDto {
    private Long id;
    private String name;
    private Double surface;
    private Double price;
    private String picture;
    private String description;
    @JsonProperty("created_at")
    private Instant createdAt;
    @JsonProperty("updated_at")
    private Instant updatedAt;
    @JsonProperty("owner_id")
    private Long ownerId;

}
