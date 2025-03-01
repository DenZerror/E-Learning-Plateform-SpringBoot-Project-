package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Users;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/add")
    public Users addUser(@RequestBody Users user ){
        return userService.addUser(user);
    }
    

    @GetMapping("/get/all")
    public List<Users> getUser(){
        return userService.getUser();
    }

    @GetMapping("/get/id:{id}")
    public Users getUserById(@PathVariable Long id){
        return userService.findById(id);
    }

    @GetMapping("/get/name:{name}")
    public List<Users> getUserbyUsername(@PathVariable String name){
        return userService.findByUsername(name);
    }

  
    @GetMapping("/student")
    public Page<Users> getPage(@RequestParam int page,@RequestParam int size){
        return userService.getPage(page,size);
    }   

    @GetMapping("/get/email:{email}")
    public List<Users> findByEmail(@PathVariable String email){
        return userService.findByEmail(email);
    }


    @GetMapping("/get/sortedbyname")
    public List<Users> getSorted(){
        return userService.getSorted();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted Successfully");
    } 

    @PutMapping("/update/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Long id,@RequestBody Users student){
        Users student1 = userService.updateUser(id,student);
        return ResponseEntity.ok(student1);
    }
}
