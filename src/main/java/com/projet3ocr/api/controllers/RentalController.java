package com.projet3ocr.api.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {
    @GetMapping("/")
   HashMap<String,String> getAllRentals(){
        HashMap<String,String> response = new HashMap<>();

        return response;
    }

    @GetMapping("/{id}")
    HashMap<String,String> getRental(@PathVariable Long id){
        HashMap<String,String> response = new HashMap<>();

        return response;
    }
    @PostMapping("/")
    HashMap<String,String> postRental(){
        HashMap<String,String> response = new HashMap<>();

        return response;
    }
    @PutMapping("/")
    HashMap<String,String> putRental(){
        HashMap<String,String> response = new HashMap<>();

        return response;
    }
}
