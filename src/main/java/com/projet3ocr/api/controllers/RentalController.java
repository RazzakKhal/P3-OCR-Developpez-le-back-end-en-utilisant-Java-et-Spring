package com.projet3ocr.api.controllers;

import com.projet3ocr.api.dtos.receiveFromView.CreateRentalDto;
import com.projet3ocr.api.dtos.sendToView.RentalDto;
import com.projet3ocr.api.dtos.receiveFromView.UpdateRentalDto;
import com.projet3ocr.api.services.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    RentalService rentalService;
    @GetMapping("")
    List<RentalDto> getAllRentals(){
        return rentalService.getAllRentals();
    }

    @GetMapping("/{id}")
    RentalDto getRental(@PathVariable Long id){
        return rentalService.getRentalById(id);
    }
    @PostMapping("/{id}")
    HashMap<String,String> postRental(@PathVariable Long id, @RequestBody CreateRentalDto rentalDto){
        return rentalService.postNewRental(id, rentalDto);
    }
    @PutMapping("/{id}")
    HashMap<String,String> putRental(@PathVariable Long id, @RequestBody UpdateRentalDto rentalDto){
        return rentalService.putExistingRental(id, rentalDto);
    }
}
