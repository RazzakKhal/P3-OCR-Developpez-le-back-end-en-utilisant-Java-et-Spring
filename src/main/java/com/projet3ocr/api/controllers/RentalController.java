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

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @Autowired
    RentalService rentalService;
    @GetMapping("")
    HashMap<String,List<RentalDto>> getAllRentals(){
        return rentalService.getAllRentals();
    }
    @GetMapping("/{id}")
    RentalDto getRental(@PathVariable Long id){
        return rentalService.getRentalById(id);
    }
    @PostMapping("/{id}")
    HashMap<String,String> postRental(@PathVariable Long id,
                                      @RequestParam("name") String name,
                                      @RequestParam("surface") Double surface,
                                      @RequestParam("price") Double price,
                                      @RequestParam("description") String description,
                                      @RequestParam("picture") MultipartFile picture ){
        HashMap<String,String> response = new HashMap<>();
        response.put("test", description);
        return rentalService.postNewRental(id, name, surface, price, description, picture);
    }
    @PutMapping("/{id}")
    HashMap<String,String> putRental(@PathVariable Long id,@Valid @RequestBody UpdateRentalDto rentalDto){
        return rentalService.putExistingRental(id, rentalDto);
    }
}
