package com.knf.dev.demo.controller;


import com.knf.dev.demo.service.impl.UserServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

   private final UserServiceImpl userServiceImpl;
   public HomeController(UserServiceImpl userServiceImpl) {

       this.userServiceImpl = userServiceImpl;
   }

   @GetMapping("/login")
   public String login() {
      return "login";
   }

   @GetMapping("/")
   public String home(Model model) {
      Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      model.addAttribute("authen", auth);
      model.addAttribute("nameUser", userServiceImpl.getNameByEmail(auth.getName()));
      System.out.println("Name: " + userServiceImpl.getNameByEmail(auth.getName()));
      return "index";
   }


}




