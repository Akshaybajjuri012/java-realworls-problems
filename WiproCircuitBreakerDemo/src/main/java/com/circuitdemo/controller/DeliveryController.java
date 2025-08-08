package com.circuitdemo.controller;


import com.circuitdemo.service.DeliveryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/check-status")
    public String checkStatus() {
        return deliveryService.getDeliveryStatus();
    }
}

