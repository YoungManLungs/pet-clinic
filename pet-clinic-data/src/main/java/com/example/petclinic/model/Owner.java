package com.example.petclinic.model;

import java.util.Set;

public class Owner extends Person {

    private Set<Pet> pets;

    public Owner(Set<Pet> pets) {
        this.pets = pets;
    }


}
