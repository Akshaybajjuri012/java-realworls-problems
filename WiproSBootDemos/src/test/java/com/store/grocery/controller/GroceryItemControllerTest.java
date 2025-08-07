package com.store.grocery.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.grocery.model.GroceryItem;
import com.store.grocery.model.GroceryItemDTO;
import com.store.grocery.service.GroceryItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GroceryItemController.class)
class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GroceryItemService groceryItemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAddGrocery() throws Exception {
        GroceryItemDTO dto = new GroceryItemDTO();
        dto.setName("Banana");
        dto.setQuantity(10);
        dto.setPrice(3.0);

        GroceryItem item = new GroceryItem();
        item.setId(1L);
        item.setName("Banana");
        item.setQuantity(10);
        item.setPrice(3.0);

        Mockito.when(groceryItemService.addGrocery(any(GroceryItemDTO.class))).thenReturn(item);

        mockMvc.perform(post("/api/grocery/add-grocery")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Banana"));
    }

    @Test
    void testGetGroceries() throws Exception {
        Mockito.when(groceryItemService.getAllGroceries()).thenReturn(Arrays.asList(new GroceryItem(), new GroceryItem()));

        mockMvc.perform(get("/api/grocery/get-groceries"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }
}
