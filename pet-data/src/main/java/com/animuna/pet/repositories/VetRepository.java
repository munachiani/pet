package com.animuna.pet.repositories;

import com.animuna.pet.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
