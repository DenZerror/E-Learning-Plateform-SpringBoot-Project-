package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Users;
import com.example.demo.repository.UserRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public Users addUser(Users user){
        return userRepo.save(user);
    }
    
    public List<Users> getUser(){
        return userRepo.findAll();
    }

    public Users findById(Long id){
        return userRepo.findById(id).orElse(null);
    }

    public List<Users> findByUsername(String name){
        return userRepo.findByUsername(name);
    }

    public Page<Users> getPage(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return userRepo.findAll(pageable);
    }

    public List<Users> getSorted(){
        return userRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
    }

    public List<Users> findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public void deleteUser(Long id){
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("User not found");
        }
    }
    
    public Users updateUser(Long id,Users us){
        Users user = userRepo.findById(id).orElseThrow(()->new EntityNotFoundException("User not found"));
        us.setId(id);
        user.setId(us.getId());
        user.setUsername(us.getUsername());
        user.setEmail(us.getEmail());
       
        return userRepo.save(user);
    }


}

