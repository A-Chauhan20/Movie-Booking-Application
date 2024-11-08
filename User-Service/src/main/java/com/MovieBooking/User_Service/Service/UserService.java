package com.MovieBooking.User_Service.Service;

import com.MovieBooking.User_Service.Entity.User;

import java.util.List;

public interface UserService {
    void registerUser(User user);

    List<User> getAllUsers();
}
