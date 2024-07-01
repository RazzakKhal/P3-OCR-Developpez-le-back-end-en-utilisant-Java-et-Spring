package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.LoginUserDto;
import com.projet3ocr.api.dtos.receiveFromView.RegisterUserDto;
import com.projet3ocr.api.dtos.sendToView.UserDto;
import com.projet3ocr.api.mappers.UserMapper;
import com.projet3ocr.api.models.User;
import com.projet3ocr.api.repositories.UserRepository;
import com.projet3ocr.api.responses.UsersResponses;
import com.projet3ocr.api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.HashMap;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRepository userRepository;
    @Override
    public HashMap<String, String> createUser(RegisterUserDto registerUserDto){
        HashMap<String,String> response = new HashMap<>();
        User user= userMapper.toEntity(registerUserDto);
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      userRepository.save(user);
        String token = jwtUtil.generateToken(user);
        response.put("token",token);
      return response;
    }
    @Override
    public HashMap<String, String> loginUser(LoginUserDto loginUserDto){
        HashMap<String,String> response = new HashMap<>();
        User user = userMapper.toEntity(loginUserDto);
        // verifier en bdd si il existe
        Optional<User> userBdd = userRepository.findByEmail(user.getEmail());
        if(userBdd.isEmpty() || !bCryptPasswordEncoder.matches(user.getPassword(),userBdd.get().getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"la combinaison nom d'utilisateur / mot de passe ne correspond à aucun utlisateur");
        }
        // si il existe vérifier que les mdp correspondent
        String token = jwtUtil.generateToken(userBdd.get());
        response.put("token",token);
        // retourner le token
        return response;
    }

    @Override
    public UserDto getMe(Object principal){
        return userMapper.toDto((User) principal);
    }
}
