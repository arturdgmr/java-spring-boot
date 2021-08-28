package com.example.bff.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableFeignClients
@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface CustomerProfile {

    @RequestMapping(method = RequestMethod.GET, value = "/registryinformation")
    String getRegistryInformation();
}
