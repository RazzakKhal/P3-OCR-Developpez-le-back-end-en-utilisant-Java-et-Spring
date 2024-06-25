package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.LoginUserDto;
import com.projet3ocr.api.dtos.receiveFromView.RegisterUserDto;
import com.projet3ocr.api.mappers.UserMapper;
import com.projet3ocr.api.models.User;
import com.projet3ocr.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;
    @Override
    public User createUser(RegisterUserDto registerUserDto){
      User user = userMapper.toEntity(registerUserDto);
      if(user != null){
          // hash mot de passe

          userRepository.save(user);
          return user;
      }else{
          return null;
      }
    }
    @Override
    public User loginUser(LoginUserDto loginUserDto){
        User user = userMapper.toEntity(loginUserDto);
        // verifier en bdd si il existe

        // si il existe vérifier que les mdp correspondent

        // retourner le token
        return user;
    }
}
