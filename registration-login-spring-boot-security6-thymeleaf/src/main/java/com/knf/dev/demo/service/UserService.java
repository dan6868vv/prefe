package com.knf.dev.demo.service;

import com.knf.dev.demo.dto.UserCreatingDto;
import com.knf.dev.demo.dto.UserRegistrationDto;
import com.knf.dev.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends UserDetailsService {
   User findUserById(long id);
   void updateUser(long id,User user);
   User save(UserRegistrationDto registrationDto);
   User saveCreate(UserCreatingDto creatingDto);
   List<User> getAll();
   User findUserByEmail(String email);

}