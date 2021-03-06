package br.com.example.demokafka.kafka.config;

import io.confluent.connect.avro.FinishRegistrationCustomer;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.Properties;

@AllArgsConstructor
@Configuration
public class KafkaConfiguration {
    private KafkaConfigData config;
    private static final String ACKS_ALL_CONSTANT = "all";

    @Bean
    public ProducerFactory<String, FinishRegistrationCustomer> producerFactory(){
        return new DefaultKafkaProducerFactory(senderProps());
    }

    private Properties senderProps() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
        props.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        props.put(ProducerConfig.ACKS_CONFIG, ACKS_ALL_CONSTANT);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        return props;
    }

    @Bean
    public KafkaTemplate<String, FinishRegistrationCustomer> kafkaTemplate(ProducerFactory<String, FinishRegistrationCustomer> producerFactory){
        return new KafkaTemplate(producerFactory);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, FinishRegistrationCustomer> kafkaListenerContainerFactory(ConsumerFactory<String, FinishRegistrationCustomer> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, FinishRegistrationCustomer> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, FinishRegistrationCustomer> consumerFactory() {
        return new DefaultKafkaConsumerFactory(consumerProps());
    }

    private Properties consumerProps() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
        props.put(ConsumerConfig.GROUP_ID_CONFIG, config.getEventsConsumerGroup());
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, config.getEventsAutoOffsetResetConfig());
        return props;
    }
}
