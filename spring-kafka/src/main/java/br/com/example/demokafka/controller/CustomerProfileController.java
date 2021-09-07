package br.com.example.demokafka.controller;

import br.com.example.demokafka.kafka.producers.CustumerRegistrationProducer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping("/customer")
public class CustomerProfileController {

    private CustumerRegistrationProducer custumerRegistrationProducer;

    @PostMapping
    public void createCustomer(@RequestBody String message){
        custumerRegistrationProducer.sendMessage(message);
    }

}
