package com.animuna.pet.services.map;

import com.animuna.pet.model.Owner;
import com.animuna.pet.model.Pet;
import com.animuna.pet.services.OwnerService;
import com.animuna.pet.services.PetService;
import com.animuna.pet.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else {
                        throw  new RuntimeException("Pet Type is required!");
                    }

                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId() );
                    }
                });
            }
            return super.save(object);
        } else {
            return  null;
        }
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }



    @Override
    public Owner findByLastname(String lastName) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastname().equalsIgnoreCase(lastName))
                .findFirst()
                .orElse(null);
    }
}
