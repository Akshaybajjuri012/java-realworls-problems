package com.store.grocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.grocery.model.GroceryItem;
import com.store.grocery.model.GroceryItemDTO;
import com.store.grocery.repository.GroceryItemRepo;

@Service
public class GroceryItemService {
    @Autowired
    private GroceryItemRepo groceryItemRepo;
    public GroceryItem addGrocery(GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem=new GroceryItem();
        groceryItem.setName(groceryItemDTO.getName());
        groceryItem.setPrice(groceryItemDTO.getPrice());
        groceryItem.setQuantity(groceryItemDTO.getQuantity());
        return groceryItemRepo.save(groceryItem);
    }
    public List<GroceryItem> getAllGroceries() {
        return groceryItemRepo.findAll();
    }
    public String deleteGrocery(long id) {
        GroceryItem groceryItem=groceryItemRepo.findById(id).orElse(null);
        if(groceryItem!=null){
            groceryItemRepo.deleteById(id);
            return "Grocery deleted with ID: "+id;
        }
        return "Given Grocery Id with "+id+" not found";
    }
    public GroceryItem updateGrocery(long id, GroceryItemDTO groceryItemDTO) {
        GroceryItem groceryItem=groceryItemRepo.findById(id).orElse(null);
        if(groceryItem!=null){
            groceryItem.setName(groceryItemDTO.getName());
            groceryItem.setPrice(groceryItemDTO.getPrice());
            groceryItem.setQuantity(groceryItemDTO.getQuantity());
            return groceryItemRepo.save(groceryItem);
        }
        return null;

    }
    
}
