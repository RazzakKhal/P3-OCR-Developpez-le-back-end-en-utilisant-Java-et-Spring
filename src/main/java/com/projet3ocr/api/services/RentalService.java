package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.CreateRentalDto;
import com.projet3ocr.api.dtos.sendToView.RentalDto;
import com.projet3ocr.api.dtos.receiveFromView.UpdateRentalDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface RentalService {
    HashMap<String,List<RentalDto>> getAllRentals();

    RentalDto getRentalById(Long id);

    HashMap<String, String> putExistingRental(Long id, String name, Double surface, Double price, String description);
    HashMap<String, String> postNewRental(Long id, String name, Double surface, Double price, String description, MultipartFile picture);
}

