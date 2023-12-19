package com.upb.adminservice.client;


import com.upb.adminservice.model.AdminDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AUTH-SERVICE/auth")
public interface AuthServiceClient {

    @PostMapping("/registerAdmin")
    void createAdmin(@RequestBody AdminDetails adminDetails);
}
