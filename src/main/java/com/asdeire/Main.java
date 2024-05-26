package com.asdeire;

import com.asdeire.persistence.model.User;
import com.asdeire.persistence.repository.UserRepositoryImpl;
import com.asdeire.persistence.repository.impl.UserRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();

        // Create a new user
        User newUser = new User();
        newUser.setUsername("newuser");
        newUser.setPassword("password");
        userRepository.save(newUser);
        System.out.println("User saved: " + newUser);

        // Read user by ID
        User user = userRepository.findById(newUser.getId());
        System.out.println("User found: " + user);

        // Update user
        user.setPassword("newpassword");
        userRepository.update(user);
        System.out.println("User updated: " + user);

        // Delete user
        userRepository.delete(user);
        System.out.println("User deleted: " + user);

        // List all users
        List<User> users = userRepository.findAll();
        System.out.println("All users: " + users);
    }
}
