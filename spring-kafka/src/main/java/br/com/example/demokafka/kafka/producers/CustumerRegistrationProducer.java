package br.com.example.demokafka.kafka.producers;

import br.com.example.demokafka.kafka.producers.converter.CustomerRegistryConverter;
import io.confluent.connect.avro.FinishRegistrationCustomer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CustumerRegistrationProducer {
    private final KafkaTemplate<String, FinishRegistrationCustomer> kafkaTemplate;
    private final CustomerRegistryConverter customerRegistryConverter;

    @Value("${kafka.listener.topics.finish-registration}")
    private String topic;

    public void sendMessage(String message){
        FinishRegistrationCustomer body = customerRegistryConverter.toCustomerRegistrationCompleted(message);
        ProducerRecord<String, FinishRegistrationCustomer> producerRecord = new ProducerRecord<String, FinishRegistrationCustomer>(topic, body);
        kafkaTemplate.send(producerRecord);
        log.info("M=sendMessage,  message={}", message);
    }

}
