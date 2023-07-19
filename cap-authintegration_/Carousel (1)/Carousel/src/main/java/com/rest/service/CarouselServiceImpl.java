package com.rest.service;

import java.io.IOException;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rest.model.Carousel;
import com.rest.repository.ICarouselRepository;

@Service
public class CarouselServiceImpl implements ICarousalService {
	@Autowired
	private ICarouselRepository carouselRepo;
	
	@Override
	public Carousel addPhoto(String propertyId) throws IOException {
		  	Carousel carousel = new Carousel();
		  	carousel.addPropertyID(propertyId);
		    return this.carouselRepo.save(carousel);
	}

	@Override
	public Carousel getPhoto(String id) {
		return this.carouselRepo.findById(id).get();
	}

	@Override
	public List<Carousel> getAllPhotos() {
		return this.carouselRepo.findAll();
	}

	@Override
	public String deleteCarousel(String cid) {
		this.carouselRepo.deleteByPropertyID(cid);
		return "Deleted Successfully!";
	}

	@Override
	public List<Carousel> getPropertyID() {
		List<Carousel> carousel = this.carouselRepo.findAll();
        return carousel;
	}
	
	

}
