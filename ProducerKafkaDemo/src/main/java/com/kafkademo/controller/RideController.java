package com.kafkademo.controller;
import com.kafkademo.dto.RideDto;
import com.kafkademo.service.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rides")
public class RideController {
	private final KafkaProducerService producerService;

    public RideController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<?> createRide(@RequestBody RideDto dto) throws Exception {
        producerService.sendMessage("CREATE", toMap(dto));
        return ResponseEntity.accepted().body("Ride create request sent to Kafka");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRide(@PathVariable Long id, @RequestBody RideDto dto) throws Exception {
        dto.setId(id);
        producerService.sendMessage("UPDATE", toMap(dto));
        return ResponseEntity.accepted().body("Ride update request sent to Kafka");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRide(@PathVariable Long id) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        producerService.sendMessage("DELETE", map);
        return ResponseEntity.accepted().body("Ride delete request sent to Kafka");
    }

    private Map<String, Object> toMap(RideDto dto) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", dto.getId());
        map.put("driverName", dto.getDriverName());
        map.put("passengerName", dto.getPassengerName());
        map.put("pickupLocation", dto.getPickupLocation());
        map.put("dropLocation", dto.getDropLocation());
        map.put("fare", dto.getFare());
        return map;
    }

}
