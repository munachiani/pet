package com.animuna.pet.repositories;

import com.animuna.pet.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
