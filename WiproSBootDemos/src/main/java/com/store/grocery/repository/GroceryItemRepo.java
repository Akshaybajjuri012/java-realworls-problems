package com.store.grocery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.grocery.model.GroceryItem;

@Repository
public interface GroceryItemRepo  extends JpaRepository<GroceryItem,Long>{

}