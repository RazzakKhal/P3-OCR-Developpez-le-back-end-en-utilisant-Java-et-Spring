package com.projet3ocr.api.repositories;

import com.projet3ocr.api.models.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long> {
}
