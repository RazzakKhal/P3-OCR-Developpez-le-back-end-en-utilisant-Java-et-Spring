package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.CreateRentalDto;
import com.projet3ocr.api.dtos.RentalDto;
import com.projet3ocr.api.dtos.UpdateRentalDto;
import com.projet3ocr.api.models.Rental;

import java.util.HashMap;
import java.util.List;

public interface RentalService {
    List<RentalDto> getAllRentals();

    RentalDto getRentalById(Long id);

    HashMap<String, String> putExistingRental(Long id, UpdateRentalDto rentalDto);
    HashMap<String, String> postNewRental(Long id, CreateRentalDto rentalDto);
}

