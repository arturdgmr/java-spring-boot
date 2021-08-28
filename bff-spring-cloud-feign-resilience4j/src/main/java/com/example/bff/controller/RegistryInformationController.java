package com.example.bff.controller;

import com.example.bff.client.CustomerProfileClient;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = {"/registryinformation"})
public class RegistryInformationController {

    private CustomerProfileClient customerProfileClient;

    @GetMapping
    @Retry(name = "customer-profile-api")
    public String getTeste(){
        log.info("Request to customer profile api is received!");
        return customerProfileClient.getRegistryInformation();
    }
}
