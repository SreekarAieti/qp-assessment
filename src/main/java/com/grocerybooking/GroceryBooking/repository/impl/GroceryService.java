package com.grocerybooking.GroceryBooking.repository.impl;

import com.grocerybooking.GroceryBooking.model.GroceryItem;
import com.grocerybooking.GroceryBooking.repository.GroceryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {
    private final GroceryRepository groceryRepository;

    public GroceryService(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    public List<GroceryItem> saveGroceryItem(List<GroceryItem> groceryItems){
        try {
            groceryItems.forEach(groceryItem -> groceryRepository.save(groceryItem));
        }catch (Exception e){
            log.error("Error in saving the item, please check the format of list");
        }
        return groceryItems;
    }

    public List<GroceryItem> getAllGrocery(){
        return groceryRepository.findAll();
    }

    public GroceryItem getItem(String id){
        GroceryItem item = null;
        try{
            item= groceryRepository.findById(id);
        }catch (Exception e){
            log.error("Iteam is not availabe in Database");
        }
        return item;
    }

    public void deleteItem(String id){
        try{
            groceryRepository.delete(id);
        }catch (Exception e){
            log.error("Item not found in DB");
        }
    }


}
