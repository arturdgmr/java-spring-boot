package com.java.springretry.strategy;

import com.java.springretry.client.BackBClient;
import com.java.springretry.model.InvestmentEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class InvestmentsStrategy {
    private final BackBClient backBClient;

    public Mono<String> strategies(String investments){
        if(Objects.equals(investments, InvestmentEnum.CDB.getNome())){
            return backBClient.getBackBCDB();
        } else {
            return backBClient.getBackBFundos();
        }
    }
}
