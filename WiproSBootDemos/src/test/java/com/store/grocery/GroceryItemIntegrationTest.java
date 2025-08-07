package com.store.grocery;

import com.store.grocery.model.GroceryItem;
import com.store.grocery.model.GroceryItemDTO;
import com.store.grocery.repository.GroceryItemRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GroceryItemIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private GroceryItemRepo groceryItemRepo;

    @Test
    void testFullFlow() {
        // Create
        GroceryItemDTO dto = new GroceryItemDTO();
        dto.setName("Orange");
        dto.setQuantity(8);
        dto.setPrice(4.5);

        ResponseEntity<GroceryItem> postResponse =
                restTemplate.postForEntity("/api/grocery/add-grocery", dto, GroceryItem.class);

        assertEquals(HttpStatus.CREATED, postResponse.getStatusCode());
        assertNotNull(postResponse.getBody());
        Long id = postResponse.getBody().getId();

        // Read
        ResponseEntity<GroceryItem[]> getResponse =
                restTemplate.getForEntity("/api/grocery/get-groceries", GroceryItem[].class);

        assertTrue(getResponse.getBody().length > 0);

        // Delete
        restTemplate.delete("/api/grocery/delete-grocery/" + id);
        assertFalse(groceryItemRepo.findById(id).isPresent());
    }
}
