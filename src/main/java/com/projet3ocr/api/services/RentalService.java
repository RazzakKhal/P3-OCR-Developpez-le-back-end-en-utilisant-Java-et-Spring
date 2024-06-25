package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.CreateRentalDto;
import com.projet3ocr.api.dtos.sendToView.RentalDto;
import com.projet3ocr.api.dtos.receiveFromView.UpdateRentalDto;

import java.util.HashMap;
import java.util.List;

public interface RentalService {
    List<RentalDto> getAllRentals();

    RentalDto getRentalById(Long id);

    HashMap<String, String> putExistingRental(Long id, UpdateRentalDto rentalDto);
    HashMap<String, String> postNewRental(Long id, CreateRentalDto rentalDto);
}

