package com.java.springwebflux.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/** Simulando uma base de dados RDBMS (relacional) */

@Component
@RequiredArgsConstructor
public class InMemoryDatabase implements Database{

    private static final Map<String, String> DATABASE = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper;

    @Override
    @SneakyThrows
    public <T> T save(final String key, final T value) {
        final String data = objectMapper.writeValueAsString(value);
        DATABASE.put(key, data);
        return value;
    }

    @Override
    public <T> Optional<T> get(final String key, final Class<T> clazz) {
        final String json = DATABASE.get(key);

        return Optional.ofNullable(json).map(data -> {
            try {
                return objectMapper.readValue(data, clazz);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
