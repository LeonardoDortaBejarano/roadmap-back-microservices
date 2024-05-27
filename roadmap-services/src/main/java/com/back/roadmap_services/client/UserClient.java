package com.back.roadmap_services.client;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@LoadBalancerClient
@FeignClient(value = "user", url = "user-services")
public interface UserClient {

    @GetMapping("/api/v1/user/{id}/exists")
    public boolean userExist(@PathVariable Integer id);

 
}
