package com.kafkademo.service;
import com.kafkademo.entity.Ride;
import com.kafkademo.repository.RideRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class KafkaConsumerService {
	private final RideRepository rideRepository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public KafkaConsumerService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    } @KafkaListener(topics = "uber-ride-topic", groupId = "uber_ride_group")
    public void consumeMessage(String message) {
        try {
            JsonNode node = objectMapper.readTree(message);
            String operation = node.get("operation").asText();

            switch (operation.toUpperCase()) {
                case "CREATE":
                    handleCreate(node);
                    break;
                case "UPDATE":
                    handleUpdate(node);
                    break;
                case "DELETE":
                    handleDelete(node);
                    break;
                default:
                    System.out.println("Unknown operation: " + operation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void handleCreate(JsonNode node) {
        Ride ride = new Ride();
        ride.setId(node.get("id").asLong());
        ride.setDriverName(node.get("driverName").asText());
        ride.setPassengerName(node.get("passengerName").asText());
        ride.setPickupLocation(node.get("pickupLocation").asText());
        ride.setDropLocation(node.get("dropLocation").asText());
        ride.setFare(node.get("fare").asDouble());
        rideRepository.save(ride);
        System.out.println("Created ride: " + ride.getId());
    }
    private void handleUpdate(JsonNode node) {
        Long id = node.get("id").asLong();
        Optional<Ride> optionalRide = rideRepository.findById(id);
        if (optionalRide.isPresent()) {
            Ride ride = optionalRide.get();
            if (node.has("driverName")) ride.setDriverName(node.get("driverName").asText());
            if (node.has("passengerName")) ride.setPassengerName(node.get("passengerName").asText());
            if (node.has("pickupLocation")) ride.setPickupLocation(node.get("pickupLocation").asText());
            if (node.has("dropLocation")) ride.setDropLocation(node.get("dropLocation").asText());
            if (node.has("fare")) ride.setFare(node.get("fare").asDouble());
            rideRepository.save(ride);
            System.out.println("Updated ride: " + id);
        }
    }
    private void handleDelete(JsonNode node) {
        Long id = node.get("id").asLong();
        rideRepository.deleteById(id);
        System.out.println("Deleted ride: " + id);
    }

}
