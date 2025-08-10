package com.kafkademo.controller;
import com.kafkademo.entity.Ride;
import com.kafkademo.repository.RideRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/rides")
public class RideController {
	 private final RideRepository rideRepository;

	    public RideController(RideRepository rideRepository) {
	        this.rideRepository = rideRepository;
	    }

	    @GetMapping
	    public List<Ride> getAllRides() {
	        return rideRepository.findAll();
	    }

	    @GetMapping("/{id}")
	    public Ride getRideById(@PathVariable Long id) {
	        return rideRepository.findById(id).orElse(null);
	    }
	

}
