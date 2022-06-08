package com.java.springretry.client;

import com.java.springretry.model.Payment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "RegistryInformationClient", url = "${config.payment-api.url}")
public interface PaymentClient {

    @RequestMapping(method = RequestMethod.GET, value = "/teste/{userId}")
    Mono<Payment> getPayment(@PathVariable("userId") String userId);

}
