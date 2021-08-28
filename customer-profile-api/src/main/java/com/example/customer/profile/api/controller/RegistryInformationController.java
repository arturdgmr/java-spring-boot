package com.example.customer.profile.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/registryinformation"})
public class RegistryInformationController {

    @GetMapping
    public String getRegistryInformation(){
        return "Informações de registro do cliente";
    }
}
