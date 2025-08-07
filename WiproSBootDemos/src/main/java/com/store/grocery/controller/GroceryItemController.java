package com.store.grocery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.grocery.model.GroceryItem;
import com.store.grocery.model.GroceryItemDTO;
import com.store.grocery.service.GroceryItemService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/grocery/")
public class GroceryItemController {
    @Autowired
    private GroceryItemService groceryItemService;
    @PostMapping("add-grocery")
    public ResponseEntity<GroceryItem> addGrocery(@Valid @RequestBody GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem=groceryItemService.addGrocery(groceryItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(groceryItem);
    }
    @GetMapping("get-groceries")
    public ResponseEntity<List<GroceryItem>> getAllGroceries() {
        return ResponseEntity.status(HttpStatus.OK).body(groceryItemService.getAllGroceries());
    }
    @DeleteMapping("delete-grocery/{id}")
    public ResponseEntity<String> deleteGrocery(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(groceryItemService.deleteGrocery(id));

    }
    @PutMapping("update-grocery/{id}")
    public ResponseEntity<GroceryItem> updateGrocery(@PathVariable long id, @RequestBody GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem=groceryItemService.updateGrocery(id,groceryItemDTO);
                return ResponseEntity.status(HttpStatus.OK).body(groceryItem);

    }
    
    
    
}