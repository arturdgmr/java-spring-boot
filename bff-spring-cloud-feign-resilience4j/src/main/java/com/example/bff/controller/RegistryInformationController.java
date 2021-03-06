package com.example.bff.controller;

import com.example.bff.client.CustomerProfileClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
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
    @CircuitBreaker(name = "customer-profile-api", fallbackMethod = "fallback")
    public String getRegistryInformation(){
        log.info("Request to customer profile api is received!");
        return customerProfileClient.getRegistryInformation();
    }

    @GetMapping("/test")
    @SneakyThrows
    public String getRegistryInformationTest() {
        //sleep();
        log.info("requisicao recebida");
        return "teste!";
    }

    private void sleep() throws InterruptedException {
        try {
            Thread.sleep(5_000);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public String fallback(Exception ex){
        return "Circuit break is open";
    }
}
