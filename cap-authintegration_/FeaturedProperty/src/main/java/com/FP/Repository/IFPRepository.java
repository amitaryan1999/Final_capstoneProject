package com.FP.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FP.model.Featured;

public interface IFPRepository extends JpaRepository<Featured, String>{

	Optional<Featured> findById(String id);

}
