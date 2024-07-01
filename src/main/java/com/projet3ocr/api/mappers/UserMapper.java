package com.projet3ocr.api.mappers;

import com.projet3ocr.api.dtos.receiveFromView.LoginUserDto;
import com.projet3ocr.api.dtos.receiveFromView.RegisterUserDto;
import com.projet3ocr.api.dtos.sendToView.UserDto;
import com.projet3ocr.api.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

   public User toEntity(RegisterUserDto registerUserDto){
        if(registerUserDto == null){
            return null;
        }
        User user = new User();
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(registerUserDto.getPassword());
        user.setName(registerUserDto.getName());

        return user;
    }

   public User toEntity(LoginUserDto loginUserDto){
        if(loginUserDto == null){
            return null;
        }
        User user = new User();
        user.setEmail(loginUserDto.getEmail());
        user.setPassword(loginUserDto.getPassword());

        return user;
    }

    public UserDto toDto(User user){
       if(user == null){
           return null;
       }
       UserDto userDto = new UserDto();

       userDto.setCreatedAt(user.getCreatedAt());
       userDto.setUpdatedAt(user.getUpdatedAt());
       userDto.setName(user.getName());
       userDto.setEmail(user.getEmail());
       userDto.setId(user.getId());

       return userDto;
    }
}
