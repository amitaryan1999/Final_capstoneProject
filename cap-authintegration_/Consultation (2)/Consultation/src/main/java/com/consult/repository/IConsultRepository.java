package com.consult.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.consult.model.Consult;

@Repository
public interface IConsultRepository extends MongoRepository<Consult, String> {

}
