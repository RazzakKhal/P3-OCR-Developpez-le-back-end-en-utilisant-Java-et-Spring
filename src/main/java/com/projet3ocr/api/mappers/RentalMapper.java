package com.projet3ocr.api.mappers;

import com.projet3ocr.api.dtos.CreateRentalDto;
import com.projet3ocr.api.dtos.RentalDto;
import com.projet3ocr.api.models.Rental;
import com.projet3ocr.api.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RentalMapper {

    public RentalDto toDto(Rental rentalEntity){
        RentalDto rentalDto = new RentalDto();

        rentalDto.setId(rentalEntity.getId());
        rentalDto.setName(rentalEntity.getName());
        rentalDto.setSurface(rentalEntity.getSurface());
        rentalDto.setPrice(rentalEntity.getPrice());
        rentalDto.setPicture(rentalEntity.getPicture());
        rentalDto.setDescription(rentalEntity.getDescription());
        rentalDto.setOwnerId(rentalEntity.getUser().getId());
        rentalDto.setCreatedAt(rentalEntity.getCreatedAt());
        rentalDto.setUpdatedAt(rentalEntity.getUpdatedAt());

        return rentalDto;
    }

    public List<RentalDto> toDto(List<Rental> rentalsEntities){
        List<RentalDto> list = new ArrayList<>();
        for(Rental rental : rentalsEntities){
            RentalDto rentalDto = toDto(rental);
            list.add(rentalDto);
        }
        return list;
    }


    public Rental toEntity(CreateRentalDto rentalDto, User user){
        Rental rental = new Rental();
        rental.setName(rentalDto.getName());
        rental.setSurface(rentalDto.getSurface());
        rental.setPrice(rentalDto.getPrice());
        rental.setPicture(rentalDto.getPicture());
        rental.setDescription(rentalDto.getDescription());
        rental.setUser(user);

        return rental;
    }
}
