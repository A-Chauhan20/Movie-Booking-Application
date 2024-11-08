package com.MovieBooking.User_Service.Service;

import com.MovieBooking.User_Service.Entity.User;
import com.MovieBooking.User_Service.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public void registerUser(User user) {
        try{
            if(userRepo.findByUsername(user.getUsername()).isPresent()){
                throw new Exception("User Already Exists");
            }
            else {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userRepo.save(user);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("Username not found..."+username));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().get(0))
                .build();
    }
}
