package com.grocerybooking.GroceryBooking.repository;

import com.grocerybooking.GroceryBooking.model.GroceryItem;

import java.util.List;

public interface GroceryRepository extends JpaRepository<GroceryItem, Long>{
    List<GroceryItem> getAllGrocery(List<String> ids);
    List<GroceryItem> saveGroceryItem(List<GroceryItem> groceryItems);
    GroceryItem getItem(String id);
    void deleteItem(String id);
}
