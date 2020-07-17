package com.tutoring.boardingkennel;
import com.tutoring.boardingkennel.models.BoardingFacility;
import com.tutoring.boardingkennel.models.Dog;
import com.tutoring.boardingkennel.models.KennelSize;
import com.tutoring.boardingkennel.repositories.BoardingFacilityRepo;
import com.tutoring.boardingkennel.repositories.DogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Populator {

    @Autowired
    BoardingFacilityRepo facilityRepo;

    @Autowired
    DogRepo dogRepo;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedBoardingFacilityTable();
        seedDogTable();
        System.out.println("Database seeded!");
    }

    private void seedBoardingFacilityTable() {
        BoardingFacility facility1 =
                new BoardingFacility("Tutor Kennel", 20, 15, 10);


        facilityRepo.save(facility1);
    }

    private void seedDogTable() {
        Dog titus = new Dog("Mastiff", 3, "Titus", "",
                4, 0, false, KennelSize.LARGE);
        Dog cookie = new Dog("Lab", 5, "Cookie", "",
                3, 0, false, KennelSize.MEDIUM);
        Dog bonnie = new Dog("Beagle", 7, "Bonnie", "",
                2, 1, true, KennelSize.SMALL);
        Dog clyde = new Dog("Beagle", 4, "Clyde", "",
                2, 1, true, KennelSize.SMALL);
        Dog max = new Dog("Yorkie Mix", 11, "Max", "",
                2, 0, false, KennelSize.SMALL);
        Dog teddy = new Dog("Yorkie", 8, "Teddy", "",
                2, 0, false, KennelSize.SMALL);
        dogRepo.save(titus);
        dogRepo.save(cookie);
        dogRepo.save(bonnie);
        dogRepo.save(clyde);
        dogRepo.save(max);
        dogRepo.save(teddy);
    }



}


