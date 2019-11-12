package com.animuna.pet.repositories;

import com.animuna.pet.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastname(String lastName);
}
