
package com.knf.dev.demo.controller;

import com.knf.dev.demo.dto.UserCreatingDto;
import com.knf.dev.demo.dto.UserRegistrationDto;
import com.knf.dev.demo.entity.User;
import com.knf.dev.demo.repository.UserRepository;

import com.knf.dev.demo.service.UserService;
import com.knf.dev.demo.service.impl.UserServiceImpl;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserRepository userRepository;
    private UserService userService;
    private UserServiceImpl userServiceImpl;
    public AdminController(UserService userService,
                           UserServiceImpl userServiceImpl, UserRepository userRepository) {
        super();
        this.userService = userService;
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping("/menu")
    public String menu(Model model) {

        return "admin/menu";
    }

    @GetMapping("/users/add")
    public String addUser(Model model) {
        model.addAttribute("user", new UserRegistrationDto());
        return "admin/addUser";
    }

    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "admin/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        userRepository.deleteById(id);
        return "redirect:/admin/users?keyword=";
    }


    @GetMapping("/users/addUser")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new UserCreatingDto());
        return "admin/addUser";
    }

    @PostMapping("/users/addUser")
    public String createUser(@ModelAttribute UserCreatingDto dto) {
        userService.saveCreate(dto);
        return "redirect:/admin/users?keyword=";
    }

    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("userId",id);
//        model.addAttribute("user", userRepository.findById(id));
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "admin/editUser";
    }

    @PostMapping("/users/edit/{id}")
    public String editUserPost(@PathVariable("id") long id,@ModelAttribute User user){
        userService.updateUser(id,user);
        return "redirect:/admin/users";
    }
}
