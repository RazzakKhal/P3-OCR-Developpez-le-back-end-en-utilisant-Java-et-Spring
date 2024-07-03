package com.projet3ocr.api.controllers;

import com.projet3ocr.api.dtos.receiveFromView.CreateRentalDto;
import com.projet3ocr.api.dtos.sendToView.RentalDto;
import com.projet3ocr.api.dtos.receiveFromView.UpdateRentalDto;
import com.projet3ocr.api.services.RentalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    RentalService rentalService;
    @GetMapping("")
    Map<String,List<RentalDto>> getAllRentals(){
        return rentalService.getAllRentals();
    }
    @GetMapping("/{id}")
    RentalDto getRental(@PathVariable Long id){
        return rentalService.getRentalById(id);
    }
    @PostMapping("/{id}")
    Map<String,String> postRental(@PathVariable Long id,
                                      @RequestParam("name") String name,
                                      @RequestParam("surface") Double surface,
                                      @RequestParam("price") Double price,
                                      @RequestParam("description") String description,
                                      @RequestParam("picture") MultipartFile picture ){

        return rentalService.postNewRental(id, name, surface, price, description, picture);
    }
    @PutMapping("/{id}")
    Map<String,String> putRental(@PathVariable Long id,
                                     @RequestParam("name") String name,
                                     @RequestParam("surface") Double surface,
                                     @RequestParam("price") Double price,
                                     @RequestParam("description") String description){
        return rentalService.putExistingRental(id, name, surface, price, description);
    }
}
