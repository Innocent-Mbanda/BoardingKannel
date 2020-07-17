package com.tutoring.boardingkennel.services;

import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.models.KennelSize;

import java.util.List;
import java.util.Map;

public interface DogService {
    void save (Dog dog);
    Dog findbyName (String name);

    List<Dog> findByKennelSize(KennelSize size);
}
