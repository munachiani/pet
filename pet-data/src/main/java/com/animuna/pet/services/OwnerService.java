package com.animuna.pet.services;

import com.animuna.pet.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastname(String firstName);

}
