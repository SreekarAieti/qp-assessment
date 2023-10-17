package com.grocerybooking.GroceryBooking.model;

import lombok.Data;
import javax.persistence.Entity;

@Data
@Entity
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private Boolean status;
}
