package com.animuna.services;

import com.animuna.model.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByName(String firstName);

}
