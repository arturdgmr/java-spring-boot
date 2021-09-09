package br.com.example.demokafka.kafka.producers;

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
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.listener.topics.finish-registration}")
    private String topic;

    public void sendMessage(String message){
        log.info("M=sendMessage,  message={}", message);
        ProducerRecord<String, String> producerRecord = new ProducerRecord<String, String>(topic, message);
        kafkaTemplate.send(producerRecord);
    }

}
