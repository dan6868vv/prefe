package com.knf.dev.demo.dto;

public class UserRegistrationDto {

   private String nickName;
   private String email;
   private String password;

   public UserRegistrationDto() {

   }

   public String getNickName() {
      return nickName;
   }

   public void setNickName(String nickName) {
      this.nickName = nickName;
   }


   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}