package com.projet3ocr.api.services;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PasswordSalterImpl implements PasswordSalter{
    @Value("${app.secret.salter}")
    private String passwordSalter;
    @Override
    public String saltPassword(String password){
        return password + passwordSalter;
    }
}
