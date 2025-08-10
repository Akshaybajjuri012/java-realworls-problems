package com.kafkademo.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
public class KafkaProducerService {
	 private final KafkaTemplate<String, String> kafkaTemplate;
	    private final ObjectMapper objectMapper;
	    private static final String TOPIC = "uber-ride-topic";

	    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	        this.objectMapper = new ObjectMapper();
	    }

	    public void sendMessage(String operation, Map<String, Object> payload) throws Exception {
	        payload.put("operation", operation);
	        String json = objectMapper.writeValueAsString(payload);
	        kafkaTemplate.send(TOPIC, String.valueOf(payload.get("id")), json);
	    }

}
