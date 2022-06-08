package com.java.springretry.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableFeignClients
@FeignClient(name = "RegistryInformationClient", url = "${config.registry-information-api.url}")
public interface RegistryInformationClient {

    @RequestMapping(method = RequestMethod.GET, value = "/registryinformation/test")
    String getRegistryInformation();

}
