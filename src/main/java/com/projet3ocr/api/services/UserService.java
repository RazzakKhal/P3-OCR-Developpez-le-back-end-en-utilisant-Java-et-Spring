package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.sendToView.UserDto;

public interface UserService {

    UserDto getOneUser(Long id);
}
