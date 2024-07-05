package com.projet3ocr.api.services;

public interface PasswordSalter {
    String saltPassword(String password);
}
