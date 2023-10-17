package com.grocerybooking.GroceryBooking.controller;

import com.grocerybooking.GroceryBooking.model.GroceryItem;
import com.grocerybooking.GroceryBooking.service.GroceryItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GroceryController {

    @Autowired
    private GroceryItems groceryItems;

    @GetMapping("/items")
    public List<GroceryItem> getItems(
            @RequestParam(name = "email") String emailId
    ){
        return groceryItems.getAllItems(emailId);
    }

    @GetMapping("/items/{id}")
    public GroceryItem getItem(@PathVariable("id") String id,
                               @RequestParam(name = "email") String emailId){
        return groceryItems.getItemById(id,emailId);
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable("id") String id,
                           @RequestParam(name = "email") String emailId){
        groceryItems.deleteGroceryItem(id,emailId);
    }

    @PostMapping("/items")
    public List<GroceryItem> orderItems(
            @RequestParam(name = "ids") List<String> ids,
            @RequestParam(name = "email") String emailId){
        return groceryItems.OrderItems(ids,emailId);
    }

    @PostMapping("/items")
    public List<GroceryItem> createItems(
            @RequestBody List<GroceryItem> groceryItemslist,
            @RequestParam(name = "email") String emailId
    ){
        return groceryItems.createItems(groceryItemslist, emailId);
    }


}
