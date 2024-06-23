package com.projet3ocr.api.services;

import com.projet3ocr.api.dtos.UserDto;
import com.projet3ocr.api.models.User;

import java.util.Optional;

public interface UserService {

    UserDto getCurrentUser(Long id);
}
