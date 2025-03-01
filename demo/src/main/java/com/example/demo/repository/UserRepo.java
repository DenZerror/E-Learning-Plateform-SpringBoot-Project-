package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Users;


@Repository
public interface UserRepo extends JpaRepository<Users , Long> {
    public List<Users> findByUsername(String username);

    @Query("SELECT u FROM Users u WHERE u.email= :email")
    public List<Users> findByEmail(String email);
}
