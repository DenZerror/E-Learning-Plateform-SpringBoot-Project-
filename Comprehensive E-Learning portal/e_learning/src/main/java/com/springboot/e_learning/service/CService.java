package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Courses;
import com.example.demo.repository.CourseRepo;

@Service
public class CourseService {
    @Autowired
    CourseRepo crepo;

    public List<Courses> findAll(){
        return crepo.findAll();
    }

}
