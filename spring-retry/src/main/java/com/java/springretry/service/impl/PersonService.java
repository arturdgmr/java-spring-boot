package com.java.springretry.service.impl;

import com.java.springretry.exceptions.TechnicalException;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;

import java.util.concurrent.TimeoutException;

public interface PersonService {
    @Retryable(value = TechnicalException.class, maxAttempts = 2, backoff = @Backoff(delay = 6000))
    ResponseEntity<String> getRegistryInformation() throws TimeoutException;

    @Recover
    ResponseEntity<String> recover(TechnicalException e);
}
