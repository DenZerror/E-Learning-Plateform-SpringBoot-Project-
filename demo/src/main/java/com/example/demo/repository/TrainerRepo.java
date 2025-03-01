package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Trainers;

@Repository
public interface TrainerRepo extends JpaRepository<Trainers, Long> {
    public List<Trainers> findByTrainerName(String trainerName);
    @Query("SELECT t FROM Trainers t WHERE t.email= :email")
    public List<Trainers> findByEmail(String email);
}
