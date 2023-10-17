package com.grocerybooking.GroceryBooking.repository;

import com.grocerybooking.GroceryBooking.model.User;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long>{
    List<User> findByEmailId(String email);
}
