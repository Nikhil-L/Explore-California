package com.nikhil.explorecali.service;

import com.nikhil.explorecali.domain.Difficulty;
import com.nikhil.explorecali.domain.Region;
import com.nikhil.explorecali.domain.Tour;
import com.nikhil.explorecali.domain.TourPackage;
import com.nikhil.explorecali.repo.TourPackageRepository;
import com.nikhil.explorecali.repo.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository, TourPackageRepository tourPackageRepository)
    {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(String title, String description, String blurb, Integer price, String duration,
                           String bullets, String keywords, String tourPackageName, Difficulty difficulty, Region region)
    {
        TourPackage tourPackage = tourPackageRepository.findById(tourPackageName).
                orElseThrow(()-> new RuntimeException("Tour Package doesn't exsist"));

        return tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    public long total()
    {
        return tourRepository.count();
    }
}
