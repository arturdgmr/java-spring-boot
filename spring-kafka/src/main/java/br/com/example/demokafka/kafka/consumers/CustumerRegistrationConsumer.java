package br.com.example.demokafka.kafka.consumers;

import io.confluent.connect.avro.FinishRegistrationCustomer;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustumerRegistrationConsumer {

    @KafkaListener(topics = "${kafka.listener.topics.finish-registration}", groupId = "${kafka.listener.events-consumer-group}")
    public void consumer(ConsumerRecord<String, FinishRegistrationCustomer> message, Acknowledgment ack){
        ack.acknowledge();
        log.info("M=consumer, message={}", message.value());
    }
}
