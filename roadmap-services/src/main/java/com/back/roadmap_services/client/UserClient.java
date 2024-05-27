package com.back.roadmap_services.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user", url = "http://localhost:8081")
public interface UserClient {

    @GetMapping("/api/v1/user/{id}/exists")
    public boolean userExist(@PathVariable Integer id);

 
}
