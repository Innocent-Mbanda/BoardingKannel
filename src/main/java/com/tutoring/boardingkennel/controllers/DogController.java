package com.tutoring.boardingkennel.controllers;

import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.services.DogServiceImpI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    @Autowired
    DogServiceImpI dogService;
    @PostMapping( path = "/addDog", consumes = "application/json", produces = "application/json")
    public ResponseEntity <Dog> addDog(@RequestBody Dog dog){
         dogService.save(dog);
         return new ResponseEntity( dog, HttpStatus.CREATED);

    }



}
