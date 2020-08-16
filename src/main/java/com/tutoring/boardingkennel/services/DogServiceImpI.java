package com.tutoring.boardingkennel.services;

import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.models.KennelSize;
import com.tutoring.boardingkennel.repositories.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional

public class DogServiceImpI implements DogService{
    @Autowired
    DogRepo dogRepo;

    @Override
    public void save(Dog dog) {
        dogRepo.save(dog);

    }

    @Override
    public Dog findbyName(String name) {
        return null;
    }

    @Override
    public List<Dog> findByKennelSize(KennelSize size) {
        return dogRepo.findByKennelSize(size);
    }

    @Override
    public List<Dog> getAllDogs() {
        return dogRepo.findAll();
    }

    @Override
    public void delete(Dog dog) {
        dogRepo.delete(dog);
    }
}
