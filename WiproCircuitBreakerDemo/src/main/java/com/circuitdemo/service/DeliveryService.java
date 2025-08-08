package com.circuitdemo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.springframework.web.reactive.function.client.WebClientRequestException;

@Service
public class DeliveryService {

    private final WebClient webClient;

    public DeliveryService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    @CircuitBreaker(name = "deliveryCB", fallbackMethod = "fallbackDeliveryStatus")
    public String getDeliveryStatus() {
        try {
            return webClient.get()
                    .uri("http://localhost:8081/delivery/status")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (WebClientRequestException | WebClientResponseException ex) {
            
            throw ex;
        } catch (Exception ex) {
           
            throw new RuntimeException(ex);
        }
    }

   
    public String fallbackDeliveryStatus(Throwable t) {
        return "Fallback: Delivery status currently unavailable.";
    }
}
