package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Courses;
import com.example.demo.service.CourseService;

@Controller
public class CourseConroller {
    @Autowired
    CourseService cservice;

    @GetMapping("/get/all")
    public List<Courses> findAll(){
        return cservice.findAll();
    }
}
