package com.tour.repository;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tour.model.ScheduleTour;


@Repository
public interface IScheduleTourRepository extends MongoRepository<ScheduleTour, Integer> {

	Optional<ScheduleTour> findByDate(String tourDate, String tourSlots);
	

//	public boolean booked(LocalDate date, List<LocalTime> slots);
//	public boolean appointmentExists(LocalDate date, String slots );
}
