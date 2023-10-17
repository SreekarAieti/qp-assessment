package com.grocerybooking.GroceryBooking.repository.impl;

import com.grocerybooking.GroceryBooking.model.User;
import com.grocerybooking.GroceryBooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsersByName(String emailId) {
        return userRepository.findByEmailId(emailId);
    }

}

