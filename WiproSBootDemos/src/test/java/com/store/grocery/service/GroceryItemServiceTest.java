package com.store.grocery.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.store.grocery.model.GroceryItem;
import com.store.grocery.model.GroceryItemDTO;
import com.store.grocery.repository.GroceryItemRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class GroceryItemServiceTest {

    @Mock
    private GroceryItemRepo groceryItemRepo;

    @InjectMocks
    private GroceryItemService groceryItemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddGrocery() {
        GroceryItemDTO dto = new GroceryItemDTO();
        dto.setName("Apple");
        dto.setQuantity(5);
        dto.setPrice(2.5);

        GroceryItem saved = new GroceryItem();
        saved.setId(1L);
        saved.setName("Apple");
        saved.setQuantity(5);
        saved.setPrice(2.5);

        when(groceryItemRepo.save(any(GroceryItem.class))).thenReturn(saved);

        GroceryItem result = groceryItemService.addGrocery(dto);

        assertEquals("Apple", result.getName());
        assertEquals(5, result.getQuantity());
        assertEquals(2.5, result.getPrice());
    }

    @Test
    void testGetAllGroceries() {
        when(groceryItemRepo.findAll()).thenReturn(Arrays.asList(new GroceryItem(), new GroceryItem()));

        List<GroceryItem> groceries = groceryItemService.getAllGroceries();

        assertEquals(2, groceries.size());
    }

    @Test
    void testDeleteGroceryFound() {
        GroceryItem item = new GroceryItem();
        item.setId(1L);

        when(groceryItemRepo.findById(1L)).thenReturn(Optional.of(item));

        String message = groceryItemService.deleteGrocery(1L);

        assertTrue(message.contains("deleted"));
        verify(groceryItemRepo, times(1)).deleteById(1L);
    }

    @Test
    void testDeleteGroceryNotFound() {
        when(groceryItemRepo.findById(1L)).thenReturn(Optional.empty());

        String message = groceryItemService.deleteGrocery(1L);

        assertTrue(message.contains("not found"));
        verify(groceryItemRepo, never()).deleteById(anyLong());
    }
}
