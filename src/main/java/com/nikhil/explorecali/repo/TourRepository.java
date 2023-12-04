package com.nikhil.explorecali.repo;

import com.nikhil.explorecali.domain.Tour;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends CrudRepository<Tour, Integer> {
}
