package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Courses;

@Repository
public interface CourseRepo extends JpaRepository<Courses,Long>{

    List<Courses> findByTitle(String title);

    @Query("SELECT c FROM Courses c WHERE c.trainer= :trainer")
    public List<Courses> findByTrainer(String trainer);
}
