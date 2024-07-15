package com.knf.dev.demo.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "my_user", uniqueConstraints =
@UniqueConstraint(columnNames = "email"))
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "nick_name")
   private String nickName;


   private String email;

   private String password;


   @ManyToMany(fetch = FetchType.EAGER,
           cascade = CascadeType.ALL)
   @JoinTable(name = "users_roles",
           joinColumns = @JoinColumn(name = "user_id",
                   referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn
                   (name = "role_id",
                           referencedColumnName = "id"))
   private Collection<Role> roles;



   public User() {

   }



   public User(String nickName, String email, String password,
               Collection<Role> roles) {
      this.nickName = nickName;
      this.email = email;
      this.password = password;
      this.roles = roles;
   }



   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
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

   public Collection<Role> getRoles() {
      return roles;
   }

   public void setRoles(Collection<Role> roles) {
      this.roles = roles;
   }
}