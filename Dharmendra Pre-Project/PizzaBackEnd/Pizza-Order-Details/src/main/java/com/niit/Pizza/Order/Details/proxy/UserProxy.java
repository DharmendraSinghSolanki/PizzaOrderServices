package com.niit.Pizza.Order.Details.proxy;


import com.niit.Pizza.Order.Details.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-services",url = "localhost:9098")
public interface UserProxy {

    @PostMapping("/api/authUser/register")
    public ResponseEntity<?> addAll(@RequestBody User user);
}


// http://localhost:9037/user/pizza/add