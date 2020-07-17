package com.tutoring.boardingkennel.services;

import com.tutoring.boardingkennel.models.BoardingFacility;
import com.tutoring.boardingkennel.models.KennelSize;
import com.tutoring.boardingkennel.repositories.BoardingFacilityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;
@Service
@Transactional
public class BoardingFacilityServiceImpl implements BoardingFacilityService{

    @Autowired
    BoardingFacilityRepo facilityRepo;
     @Autowired
     DogService dogService;
    @Override
    public Map<String, Integer> getAvailability() {
        HashMap<String, Integer> availability = new HashMap<>();
        BoardingFacility boardingFacility = facilityRepo.findByName("Tutor Kennel");
        availability.put("totalNumSmallKennels", boardingFacility.getNumberOfSmallKennels());
        availability.put("numOfSmallDogs", dogService.findByKennelSize(KennelSize.SMALL).size());
        int smallKennelsAvailable = availability.get("totalNumSmallKennels") - availability.get("numOfSmallDogs");
        availability.put("smallKennelsAvailable", smallKennelsAvailable);

        availability.put("totalNumMedKennels", boardingFacility.getNumberOfMediumKennels());
        availability.put("numOfMedDogs", dogService.findByKennelSize(KennelSize.MEDIUM).size());
        int mediumKennelsAvailable = availability.get("totalNumMedKennels") - availability.get("numOfMedDogs");
        availability.put("mediumKennelsAvailable", mediumKennelsAvailable);

        availability.put("totalNumLargeKennels", boardingFacility.getNumberOfLargeKennels());
        availability.put("numOfLargeDogs", dogService.findByKennelSize(KennelSize.LARGE).size());
        int largeKennelsAvailable = availability.get("totalNumLargeKennels") - availability.get("numOfLargeDogs");
        availability.put("largeKennelsAvailable", largeKennelsAvailable);

        return availability;

    }


    

}
