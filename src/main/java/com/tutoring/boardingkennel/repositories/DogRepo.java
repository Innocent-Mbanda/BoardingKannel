package com.tutoring.boardingkennel.repositories;

import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.models.KennelSize;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DogRepo extends JpaRepository <Dog, Long> {

Dog findByName(String name);


    List<Dog> findByKennelSize(KennelSize size);

}
