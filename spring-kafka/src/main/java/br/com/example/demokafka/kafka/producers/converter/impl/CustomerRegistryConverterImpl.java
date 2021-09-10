package br.com.example.demokafka.kafka.producers.converter.impl;

import br.com.example.demokafka.kafka.producers.converter.CustomerRegistryConverter;
import io.confluent.connect.avro.FinishRegistrationCustomer;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegistryConverterImpl implements CustomerRegistryConverter {

    @Override
    public FinishRegistrationCustomer toCustomerRegistrationCompleted(String message) {
        return FinishRegistrationCustomer
                .newBuilder()
                .setMessage(message)
                .build();
    }
}
