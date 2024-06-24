package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.UserDto;
import com.projet3ocr.api.mappers.UserMapper;
import com.projet3ocr.api.models.User;
import com.projet3ocr.api.repositories.UserRepository;
import com.projet3ocr.api.responses.UsersResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    /**
     * Récupère un utilisateur à partir de son id et si il existe en bdd retourne toutes ses infos sauf password
     * @param id
     * @return
     */
    @Override
    public UserDto getOneUser(Long id){

        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, UsersResponses.NOT_FOUNDED_USER.getValue());
        }
        return userMapper.toDto(user.get());
    }
}
