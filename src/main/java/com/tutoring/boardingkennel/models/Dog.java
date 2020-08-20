package com.tutoring.boardingkennel.models;

import javax.persistence.*;

@Entity
public class Dog {

       @Id
       @GeneratedValue
       private long id;
        private String breed;
        private int age;
        private  String name;
        private String allergies;
        private int amountOfFood; //in cups
        private int amountOfFed; //amount of food given to dog today.
        private boolean isfeed;
        @Enumerated(EnumType.ORDINAL)
        private KennelSize kennelSize;

        public Dog (){
            this.allergies = "";
        }
        public Dog ( String bread, int age, String name, String  allergies,
                     int amountOfFood,  int amountOfFed, boolean isfeed,KennelSize kannelSize){
            this.breed = bread;
            this.allergies = allergies;
            this. name =name;
            this.amountOfFood = amountOfFood;
            this.amountOfFed = amountOfFed;
            this.isfeed = isfeed;
            this.kennelSize =kannelSize;
            this.amountOfFed =0;
            this.age =age;
        }

        public void printDogInformation() {
            System.out.println( name +"s bread is "+ breed);
            System.out.println(name +"'s bread is "+age);
            System.out.println( name +"'s bread is "+ amountOfFood); //in cups

            if( !allergies.isEmpty()) {
                System.out.println(name + "s' alligies are" + allergies);
            }else {
                System.out.println(name +"does not have any allergies");
            }



        }

        public void feedDog(int amountOfFood) {
            if (isfeed ){
                System.out.println( name +" has been fed");
            } else {
                System.out.println(name +"has been given" + amountOfFood + "cups of food");
                amountOfFood = amountOfFed +amountOfFood;
                if (amountOfFood >= this.amountOfFood){
                    isfeed =true;
                }
            }

        }

    public long getId() {
        return id;
    }

    public String getBreed() {
            return breed;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public String getAllergies() {
            return allergies;
        }

        public int getAmountOfFood() {
            return amountOfFood;
        }

        public int getAmountOfFed() {
            return amountOfFed;
        }

        public boolean isIsfeed() {
            return isfeed;
        }

        public KennelSize getKennelSize() {
            return kennelSize;
        }


        public void setBreed(String bread) {
            this.breed = bread;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAllergies(String alligies) {
            this.allergies = alligies;
        }

        public void setAmountOfFood(int amountOfFood) {
            this.amountOfFood = amountOfFood;
        }

        public void setAmountOfFed(int amountOfFed) {
            this.amountOfFed = amountOfFed;
        }

        public void setFed(boolean isfeed) {
            this.isfeed = isfeed;
        }

        public void setKennelSize(KennelSize kennelSize) {
            this.kennelSize = kennelSize;
        }

    }


