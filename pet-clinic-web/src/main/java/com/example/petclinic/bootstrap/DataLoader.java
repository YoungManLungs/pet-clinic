package com.example.petclinic.bootstrap;

import com.example.petclinic.model.*;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.PetTypeService;
import com.example.petclinic.services.SpecialitiesService;
import com.example.petclinic.services.VetService;
import com.example.petclinic.services.map.OwnerServiceMap;
import com.example.petclinic.services.map.VetServiceMap;
import org.apache.tomcat.jni.Local;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiesService specialitiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialitiesService specialitiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        Speciality quantumBellyscratching = new Speciality();
        quantumBellyscratching.setDescription("Dogs love it, drives cats up the wall");

        Speciality savedQuantumBellyscratching = specialitiesService.save(quantumBellyscratching);

        PetType dog = new PetType();
        dog.setName("dog");

        PetType cat = new PetType();
        dog.setName("cat");

        PetType savedDogPetType = petTypeService.save(dog);
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("One");
        owner1.setLastName("Guy");
        owner1.setAddress("florida");
        owner1.setCity("Miami");
        owner1.setTelephone("123456789");

        Pet doggo = new Pet();
        doggo.setPetType(savedDogPetType);
        doggo.setOwner(owner1);
        doggo.setName("Borkster");
        doggo.setBirthDate(LocalDate.now());
        owner1.getPets().add(doggo);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Two");
        owner2.setLastName("Dude");
        owner2.setAddress("florida");
        owner2.setCity("Miami");
        owner2.setTelephone("123456789");

        Pet knifeCat = new Pet();
        knifeCat.setPetType(savedCatPetType);
        knifeCat.setOwner(owner2);
        knifeCat.setName("Smuggles");


        knifeCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(knifeCat);

        ownerService.save(owner2);

        System.out.println("Loading Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Bungleton");
        vet1.getSpeciality().add(savedQuantumBellyscratching);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Samington");
        vet2.setLastName("Bungle");
        vet2.getSpeciality().add(savedQuantumBellyscratching);

        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
