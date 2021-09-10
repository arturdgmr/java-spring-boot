package br.com.example.demokafka.kafka.producers.converter;

import io.confluent.connect.avro.FinishRegistrationCustomer;

public interface CustomerRegistryConverter {
    FinishRegistrationCustomer toCustomerRegistrationCompleted(String message);
}
