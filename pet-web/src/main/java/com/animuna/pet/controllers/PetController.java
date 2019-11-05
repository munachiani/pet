package com.animuna.pet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pets")
@Controller
public class PetController {

    @RequestMapping({"/",""})
    public String listPets() {
        return "pets/index";
    }
}
