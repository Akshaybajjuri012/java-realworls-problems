package com.example.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

@SuppressWarnings("unused")
@RestController
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    

    @GetMapping("/order")
    public String placeOrder() {
        String paymentResponse = restTemplate.getForObject(
                "http://localhost:8082/payment",
                String.class
        );
        return "Order placed. " + paymentResponse;
    }
}
