package com.example.paymentservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/payment")
    public String processPayment() throws InterruptedException {
        Thread.sleep(500);
        return "Payment processed successfully!";
    }
}
