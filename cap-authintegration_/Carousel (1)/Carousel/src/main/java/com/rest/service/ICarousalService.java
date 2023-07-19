package com.rest.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.rest.model.Carousel;

public interface ICarousalService {

    public Carousel addPhoto(String propertyId) throws IOException;

    public Carousel getPhoto(String id);
    public List<Carousel> getAllPhotos();
    public String deleteCarousel(String cid);
    public List<Carousel> getPropertyID();
}
