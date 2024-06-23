package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.UserDto;
import com.projet3ocr.api.mappers.UserMapper;
import com.projet3ocr.api.models.User;
import com.projet3ocr.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto getCurrentUser(Long id){

        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()){
           return null;
        }
        return userMapper.toDto(user.get());
    }
}
