package com.grocerybooking.GroceryBooking.service.impl;

import com.grocerybooking.GroceryBooking.model.GroceryItem;
import com.grocerybooking.GroceryBooking.model.User;
import com.grocerybooking.GroceryBooking.repository.GroceryRepository;
import com.grocerybooking.GroceryBooking.repository.UserRepository;
import com.grocerybooking.GroceryBooking.service.GroceryItems;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GroceryItemsImpl implements GroceryItems {

    @Autowired
    UserRepository userRepository;
    GroceryRepository groceryRepository;

    @Override
    public List<GroceryItem> createItems(List<GroceryItem> groceryItem, String emailId) {
        List<User> users= null;
        try {
           users = userRepository.findByEmailId(emailId);
        }catch (Exception e){
            log.error("EmailID not found");
        }
        if(users.getRole() != "ADMIN"){
            log.error("User doesn't have create permissions");
        }else {
            groceryRepository.saveGroceryItem(groceryItem);
        }
        return groceryItem;
    }

    @Override
    public List<GroceryItem> getAllItems(String emailId) {
        return groceryRepository.getAllGrocery();
    }

    @Override
    public GroceryItem getItemById(String id, String emailId) {
        return groceryRepository.getItem(id);
    }

    @Override
    public void deleteGroceryItem(String id, String emailId) {
        List<User> users= null;
        try {
            users = userRepository.findByEmailId(emailId);
        }catch (Exception e){
            log.error("EmailID not found");
        }
        if(users.getRole() != "ADMIN"){
            log.error("User doesn't have delete permissions");
        }else {
            groceryRepository.deleteItem(id);
        }

    }

    @Override
    public List<GroceryItem> OrderItems(List<String> ids, String emailId) {
        return groceryRepository.getAllGrocery(ids);
    }
}
