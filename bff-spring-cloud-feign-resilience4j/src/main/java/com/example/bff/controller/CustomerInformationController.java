package com.example.bff.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = {"/customerinformation"})
public class CustomerInformationController {

    @GetMapping("/teste")
    public String getTeste(){
        return "Artur Rodrigues";
    }
}
