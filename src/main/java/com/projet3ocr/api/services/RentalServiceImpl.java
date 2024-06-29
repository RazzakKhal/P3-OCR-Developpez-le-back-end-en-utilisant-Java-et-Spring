package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.CreateRentalDto;
import com.projet3ocr.api.dtos.sendToView.RentalDto;
import com.projet3ocr.api.dtos.receiveFromView.UpdateRentalDto;
import com.projet3ocr.api.mappers.RentalMapper;
import com.projet3ocr.api.models.Rental;
import com.projet3ocr.api.models.User;
import com.projet3ocr.api.repositories.RentalRepository;
import com.projet3ocr.api.repositories.UserRepository;
import com.projet3ocr.api.responses.UsersResponses;
import com.projet3ocr.api.responses.RentalResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class RentalServiceImpl implements RentalService{
    @Autowired
    ImageService imageService;
    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    RentalMapper rentalMapper;

    @Value("${api.url}")
    private String APPLICATION_URL;

    @Override
    public HashMap<String,List<RentalDto>> getAllRentals(){
        HashMap<String,List<RentalDto>> response = new HashMap<>();
        response.put("rentals", rentalMapper.toDto(rentalRepository.findAll()));
        return response;
    }

    @Override
    public RentalDto getRentalById(Long id){
        Optional<Rental> optRental = rentalRepository.findById(id);
        if(optRental.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, RentalResponses.NOT_FOUNDED_RENTAL.getValue());
        }
        return rentalMapper.toDto(optRental.get());
    }

    /**
     * Si utilisateur fourni depuis la path variable existe alors on créé notre Location
     * @param id
     * @param name
     * @param surface
     * @param price
     * @param description
     * @param picture
     * @return
     */
    @Override
    public HashMap<String, String> postNewRental(Long id, String name, Double surface, Double price, String description, MultipartFile picture) {
        CreateRentalDto createRentalDto= new CreateRentalDto(name, surface, price, description, picture);
        HashMap<String,String> response = new HashMap<>();
        Optional<User> optUser = userRepository.findById(id);
        if(optUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, UsersResponses.NOT_FOUNDED_USER.getValue());
        }
        Rental rental = rentalMapper.toEntity(createRentalDto, optUser.get());

        try{
            String imageUrl = imageService.saveFileOnServerAndReturnFileUrl(picture);
            rental.setPicture(APPLICATION_URL + imageUrl);
        }catch(IOException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, UsersResponses.NOT_FOUNDED_USER.getValue());
        }
        rentalRepository.save(rental);
        response.put("message", RentalResponses.CREATED_RENTAL.getValue());

        return response;
    }

    /**
     * Si location fourni depuis la path variable existe et a été modifié alors on l'update en BDD
     * @param id
     * @param rentalDto
     * @return
     */
    @Override
    public HashMap<String, String> putExistingRental(Long id, UpdateRentalDto rentalDto){
        HashMap<String,String> response = new HashMap<>();
        Optional<Rental> optRental = rentalRepository.findById(id);
        if(optRental.isEmpty()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, RentalResponses.NOT_FOUNDED_RENTAL.getValue());
        }
        if(this.isAnUpdatedRental(rentalDto, optRental.get())){
            this.rentalRepository.save(this.applyModification(rentalDto,optRental.get()));
            response.put("message", RentalResponses.UPDATED_RENTAL.getValue());
        }else{
            response.put("message", RentalResponses.SIMILAR_RENTAL_EXISTING.getValue());
        }
        return response;

    }

    /**
     * Vérifie qu'une location ait bien été modifiée
     * @param rentalDto
     * @param rental
     * @return
     */
    private boolean isAnUpdatedRental(UpdateRentalDto rentalDto, Rental rental){
        return !(
        rentalDto.getName().equals(rental.getName()) &&
        rentalDto.getSurface().equals(rental.getSurface()) &&
        rentalDto.getPrice().equals(rental.getPrice()) &&
        rentalDto.getDescription().equals(rental.getDescription())
        );
    }

    /**
     * Modifie la location de sorte à ce qu'elle corresponde aux valeurs retournées par le front
     * @param rentalDto
     * @param rental
     * @return
     */
    private Rental applyModification(UpdateRentalDto rentalDto, Rental rental){
        rental.setName(rentalDto.getName());
        rental.setDescription(rentalDto.getDescription());
        rental.setSurface(rentalDto.getSurface());
        rental.setPrice(rentalDto.getPrice());

        return rental;
    }
}
