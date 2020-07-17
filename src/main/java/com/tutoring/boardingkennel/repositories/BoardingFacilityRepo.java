package com.tutoring.boardingkennel.repositories;

import com.tutoring.boardingkennel.models.BoardingFacility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardingFacilityRepo extends JpaRepository  <BoardingFacility, Long>{

    BoardingFacility findByName(String name);
}
