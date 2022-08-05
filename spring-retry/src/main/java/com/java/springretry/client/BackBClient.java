package com.java.springretry.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactivefeign.spring.config.ReactiveFeignClient;
import reactor.core.publisher.Mono;

@ReactiveFeignClient(name = "BackBClient", url = "${config.back_b.url}")
public interface BackBClient {

    @RequestMapping(method = RequestMethod.GET, value = "/backendb/fundos")
    Mono<String> getBackBFundos();

    @RequestMapping(method = RequestMethod.GET, value = "/backendb/cdb")
    Mono<String> getBackBCDB();

}
