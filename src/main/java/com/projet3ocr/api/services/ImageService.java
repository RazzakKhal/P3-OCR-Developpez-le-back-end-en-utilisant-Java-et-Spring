package com.projet3ocr.api.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService {
    String saveFileOnServerAndReturnFileUrl(MultipartFile image) throws IOException;
}
