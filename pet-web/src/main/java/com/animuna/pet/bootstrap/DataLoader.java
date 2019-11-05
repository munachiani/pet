package com.animuna.pet.bootstrap;

import com.animuna.model.Owner;
import com.animuna.model.Vet;
import com.animuna.services.OwnerService;
import com.animuna.services.VetService;
import com.animuna.services.map.OwnerServiceMap;
import com.animuna.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstname("Mike");
        owner1.setLastname("Adenuga");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(1L);
        owner2.setFirstname("Nita");
        owner2.setLastname("Scott");
        ownerService.save(owner2);

        System.out.println("Loading Owners...........");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstname("Sam");
        vet1.setLastname("Eze");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstname("Okonkwo");
        vet2.setLastname("Igbo");
        vetService.save(vet2);

        System.out.println("Loading Vets...........");
    }
}
