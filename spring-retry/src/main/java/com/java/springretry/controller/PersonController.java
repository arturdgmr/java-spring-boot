package com.java.springretry.controller;

import com.java.springretry.model.PaymentInfomation;
import com.java.springretry.service.impl.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.*;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @SneakyThrows
    @GetMapping
    public ResponseEntity<String> getPersonById() {
        return personService.getRegistryInformation();
    }

}
