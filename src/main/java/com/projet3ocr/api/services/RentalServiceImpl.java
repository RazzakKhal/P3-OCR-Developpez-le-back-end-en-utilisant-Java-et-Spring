package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.CreateRentalDto;
import com.projet3ocr.api.dtos.sendToView.RentalDto;
import com.projet3ocr.api.dtos.receiveFromView.UpdateRentalDto;
import com.projet3ocr.api.mappers.RentalMapper;
import com.projet3ocr.api.models.Rental;
import com.projet3ocr.api.models.User;
import com.projet3ocr.api.repositories.RentalRepository;
import com.projet3ocr.api.repositories.UserRepository;
import com.projet3ocr.api.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Map<String,List<RentalDto>> getAllRentals(){
        return new ApiResponseWithDto<EnumKey, List<RentalDto>>(KeysResponsesEnum.RENTALS_KEY, rentalMapper.toDto(rentalRepository.findAll())).getResponse();

    }

    /**
     * récupère une location à partir de son id
     * @param id id de la location à récupérer
     * @return
     */
    @Override
    public RentalDto getRentalById(Long id){
        Optional<Rental> optRental = rentalRepository.findById(id);
        if(optRental.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, RentalResponsesEnum.NOT_FOUNDED_RENTAL.getValue());
        }
        return rentalMapper.toDto(optRental.get());
    }

    /**
     * Si utilisateur récupuré depuis l'id de la variable de chemin existe alors on créé notre Location
     * @param id id de l'utilisateur a qui appartient la location
     * @param name
     * @param surface
     * @param price
     * @param description
     * @param picture
     * @return
     */
    @Override
    public Map<String, String> postNewRental(Long id, String name, Double surface, Double price, String description, MultipartFile picture) {
        CreateRentalDto createRentalDto= new CreateRentalDto(name, surface, price, description);
        Optional<User> optUser = userRepository.findById(id);
        if(optUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, UserResponsesEnum.NOT_FOUNDED_USER.getValue());
        }
        Rental rental = rentalMapper.toEntity(createRentalDto, optUser.get());

        try{
            String imageUrl = imageService.saveFileOnServerAndReturnFileUrl(picture);
            rental.setPicture(APPLICATION_URL + imageUrl);
        }catch(IOException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, UserResponsesEnum.NOT_FOUNDED_USER.getValue());
        }
        rentalRepository.save(rental);
        return new ApiResponseWithString<EnumKey, EnumResponse>(KeysResponsesEnum.MESSAGE_KEY, RentalResponsesEnum.CREATED_RENTAL).getResponse();

    }

    /**
     * Si location récuépré  depuis l'id de la path variable existe et a été modifié alors on l'update en BDD
     * @param id id de la location à modifier
     * @param
     * @return
     */
    @Override
    public Map<String, String> putExistingRental(Long id, String name, Double surface, Double price, String description){
        Optional<Rental> optRental = rentalRepository.findById(id);
        if(optRental.isEmpty()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, RentalResponsesEnum.NOT_FOUNDED_RENTAL.getValue());
        }
        UpdateRentalDto rentalDto = new UpdateRentalDto(name, surface, price, description);
        if(this.isAnUpdatedRental(rentalDto, optRental.get())){
            this.rentalRepository.save(this.applyModification(rentalDto,optRental.get()));
            return new ApiResponseWithString<EnumKey, EnumResponse>(KeysResponsesEnum.MESSAGE_KEY, RentalResponsesEnum.UPDATED_RENTAL).getResponse();

        }else{
            return new ApiResponseWithString<EnumKey, EnumResponse>(KeysResponsesEnum.MESSAGE_KEY, RentalResponsesEnum.SIMILAR_RENTAL_EXISTING).getResponse();

        }


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
