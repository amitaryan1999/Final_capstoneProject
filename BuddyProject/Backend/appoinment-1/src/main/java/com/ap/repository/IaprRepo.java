package com.ap.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ap.model.apUser;

@Repository
public interface IaprRepo extends MongoRepository<apUser, Integer>  {

	Optional<apUser> findByDate(String appointDate, String appointSlots);

}
