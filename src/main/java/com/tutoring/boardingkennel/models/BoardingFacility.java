package com.tutoring.boardingkennel.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Describes the boarding facility.
 * Has number of each size kennel available,
 * how many dogs boarding in each kennel size, and a list of dogs currently boarding
 *
 * Has a method to calculate the total number of dogs in the facility and to feed all dogs that are boarding
 *
 * @author Mikaila Williams
 * @version 1.0
 */
@Entity
public class BoardingFacility {
    private String name;
    @Id
    @GeneratedValue
    private Long id;
    private int numberOfSmallKennels;
    private int numberOfMediumKennels;
    private int numberOfLargeKennels;
//    private List<Dog> dogs;

    public BoardingFacility(){

    }
    public BoardingFacility(String name,int numberOfLargeKennels,
           int numberOfMediumKennels,int numberOfSmallKennels){
        this.name = name;
//        this.dogs =dogs;
        this.numberOfSmallKennels =numberOfSmallKennels;
        this.numberOfMediumKennels =numberOfMediumKennels;
        this.numberOfLargeKennels =numberOfLargeKennels;

    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public int getNumberOfSmallKennels() {
        return numberOfSmallKennels;
    }

    public int getNumberOfMediumKennels() {
        return numberOfMediumKennels;
    }

    public int getNumberOfLargeKennels() {
        return numberOfLargeKennels;
    }

//    public List<Dog> getDogs() {
//        return dogs;
//    }
}




