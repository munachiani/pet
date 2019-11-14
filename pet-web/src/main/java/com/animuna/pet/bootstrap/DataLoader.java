package com.animuna.pet.bootstrap;

import com.animuna.pet.model.*;
import com.animuna.pet.services.OwnerService;
import com.animuna.pet.services.PetTypeService;
import com.animuna.pet.services.SpecialtyService;
import com.animuna.pet.services.VetService;
import com.animuna.pet.services.map.PetTypeServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {


    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService,PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loading PetTypes........");

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery =  specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loading Specialties........");

        Owner owner1 = new Owner();
        owner1.setFirstname("Mike");
        owner1.setLastname("Adenuga");
        owner1.setAddress("123");
        owner1.setCity("Enugu");
        owner1.setTelephone("87654498");
        
        Pet adenugasPet = new Pet();
        adenugasPet.setPetType(savedDogPetType);
        adenugasPet.setOwner(owner1);
        adenugasPet.setBirthDate(LocalDate.now());
        adenugasPet.setName("Bingo");
        owner1.getPets().add(adenugasPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("Nita");
        owner2.setLastname("Scott");
        owner2.setAddress("7662");
        owner2.setCity("Nsukka");
        owner2.setTelephone("09987682");

        Pet nitasPet = new Pet();
        nitasPet.setPetType(savedCatPetType);
        nitasPet.setOwner(owner2);
        nitasPet.setBirthDate(LocalDate.now());
        nitasPet.setName("Catty");
        owner2.getPets().add(nitasPet);

        ownerService.save(owner2);

        System.out.println("Loading Owners...........");

        Vet vet1 = new Vet();
        vet1.setFirstname("Sam");
        vet1.setLastname("Eze");
        vet1.getSpecialties().add(savedDentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Okonkwo");
        vet2.setLastname("Igbo");
        vet2.getSpecialties().add(savedRadiology);
        vetService.save(vet2);

        System.out.println("Loading Vets...........");
    }
}
