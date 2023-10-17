package com.grocerybooking.GroceryBooking.service;

import com.grocerybooking.GroceryBooking.model.GroceryItem;

import java.util.List;

public interface GroceryItems {
    public List<GroceryItem> createItems(List<GroceryItem> groceryItem,String username);
    public List<GroceryItem> getAllItems(String emailId);
    public GroceryItem getItemById(String id, String emailId);
    public void deleteGroceryItem(String id, String emailId);
    public List<GroceryItem> OrderItems(List<String> ids, String emailId);

}
