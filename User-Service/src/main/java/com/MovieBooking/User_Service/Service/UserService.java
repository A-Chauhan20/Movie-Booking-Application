package com.MovieBooking.User_Service.Service;

import com.MovieBooking.User_Service.Entity.User;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    List<User> getAllUsers();
}
