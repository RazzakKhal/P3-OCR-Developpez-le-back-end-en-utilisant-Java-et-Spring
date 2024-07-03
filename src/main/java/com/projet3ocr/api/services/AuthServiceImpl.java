package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.receiveFromView.LoginUserDto;
import com.projet3ocr.api.dtos.receiveFromView.RegisterUserDto;
import com.projet3ocr.api.dtos.sendToView.UserDto;
import com.projet3ocr.api.mappers.UserMapper;
import com.projet3ocr.api.models.User;
import com.projet3ocr.api.repositories.UserRepository;
import com.projet3ocr.api.responses.ApiResponseWithToken;
import com.projet3ocr.api.responses.EnumKey;
import com.projet3ocr.api.responses.KeysResponsesEnum;
import com.projet3ocr.api.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
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
    @Autowired
    PasswordSalter passwordSalter;
    @Override
    public Map<String, String> createUser(RegisterUserDto registerUserDto){
        if(userRepository.findByEmail(registerUserDto.getEmail()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"un utilisateur avec cette identifiant existe déjà");
        }
        User user= userMapper.toEntity(registerUserDto);
        user.setPassword(bCryptPasswordEncoder.encode(passwordSalter.saltPassword(user.getPassword())));
        userRepository.save(user);
        String token = jwtUtil.generateToken(user);
        return new ApiResponseWithToken<EnumKey>(KeysResponsesEnum.TOKEN_KEY, token).getResponse();
    }
    @Override
    public Map<String, String> loginUser(LoginUserDto loginUserDto){
        User user = userMapper.toEntity(loginUserDto);
        Optional<User> userBdd = userRepository.findByEmail(user.getEmail());
        if(userBdd.isEmpty() || !bCryptPasswordEncoder.matches(passwordSalter.saltPassword(user.getPassword()),userBdd.get().getPassword())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"la combinaison nom d'utilisateur / mot de passe ne correspond à aucun utlisateur");
        }
        String token = jwtUtil.generateToken(userBdd.get());
        return new ApiResponseWithToken<EnumKey>(KeysResponsesEnum.TOKEN_KEY, token).getResponse();
    }

    @Override
    public UserDto getMe(Object principal){
        return userMapper.toDto((User) principal);
    }
}
