package com.example.petclinic.bootstrap;

import com.example.petclinic.model.Owner;
import com.example.petclinic.model.Vet;
import com.example.petclinic.services.OwnerService;
import com.example.petclinic.services.VetService;
import com.example.petclinic.services.map.OwnerServiceMap;
import com.example.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("One");
        owner1.setLastName("Guy");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Two");
        owner2.setLastName("Dude");

        ownerService.save(owner2);

        System.out.println("Loading Owners ...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Bungleton");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Samington");
        vet2.setLastName("Bungle");

        vetService.save(vet2);

        System.out.println("Loaded Vets ...");
    }
}
