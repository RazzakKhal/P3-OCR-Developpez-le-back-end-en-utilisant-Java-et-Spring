package com.projet3ocr.api.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService{
    private final String UPLOAD_DIRECTORY = "upload";
    @Override
    public String saveFileOnServerAndReturnFileUrl(MultipartFile image) throws IOException {
        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        Path filePath = this.creationOfDirectoryIfNotExistAndReturnPath().resolve(fileName);
        Files.copy(image.getInputStream(), filePath);

        return UPLOAD_DIRECTORY + "/" + fileName;
    }
    private Path creationOfDirectoryIfNotExistAndReturnPath() throws IOException {
        Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        return uploadPath;
    }



}
