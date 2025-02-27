package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
    public List<Student> findByName(String name);

    @Query("SELECT e FROM Student e WHERE e.emailaddress= :email")
    public List<Student> findByEmail(String email);
}