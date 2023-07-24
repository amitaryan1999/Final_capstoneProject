package com.rest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rest.model.Carousel;

public interface ICarouselRepository extends MongoRepository<Carousel, String> {

	public void deleteByPropertyID(String cid);
}
