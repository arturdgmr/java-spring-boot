package br.com.example.kafka.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "kafka.listener")
public class KafkaConfigData {
    private String bootstrapServers;
    private String eventsConsumerGroup;
    private String eventsAutoOffsetResetConfig;

}
