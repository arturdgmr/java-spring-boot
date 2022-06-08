package com.java.springretry.service.impl;

import com.java.springretry.client.RegistryInformationClient;
import com.java.springretry.exceptions.TechnicalException;
import feign.FeignException;
import feign.RetryableException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final RegistryInformationClient registryInformationClient;

    @Override
    public ResponseEntity<String> getRegistryInformation() {
        try {
            log.info("requisicao recebida!");

            ExecutorService executor = Executors.newSingleThreadExecutor();
            Future<String> future = executor.submit(new Task());

            return ResponseEntity.ok(future.get(3, TimeUnit.SECONDS));
        } catch (final FeignException | TimeoutException | InterruptedException | ExecutionException ex) {
            log.info("Erro!");
            throw new TechnicalException("Problema ao tentar conectar com servico externo", ex.getMessage());
        }
    }

    @Override
    public ResponseEntity<String> recover(TechnicalException e) {
        log.info("Recover acionado após duas tentativas!");
        return new ResponseEntity<String>(HttpStatus.FAILED_DEPENDENCY);
    }

    class Task implements Callable<String> {
        @Override
        public String call() {
            return registryInformationClient.getRegistryInformation();
        }
    }
}
