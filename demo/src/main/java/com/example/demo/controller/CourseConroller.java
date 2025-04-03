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

import com.example.demo.entity.Courses;
import com.example.demo.service.CourseService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/courses")
@Transactional
public class CourseConroller {
    @Autowired
    CourseService courseservice;


    @PostMapping("/add")
    public Courses addCourses(@RequestBody Courses stud){
        return courseservice.addCourses(stud);
    }

    @GetMapping("/get/all")
    public List<Courses> getCourses(){
        return courseservice.getCourses();
    }

    @GetMapping("/get/id:{id}")
    public Courses getTrainerbyId(@PathVariable Long id){
        return courseservice.findById(id);
    }

    @GetMapping("/get/trainer:{name}")
    public List<Courses> getTrainerbyName(@PathVariable String name){
        return courseservice.findByTrainer(name);
    }

  
    @GetMapping("/courses")
    public Page<Courses> getPage(@RequestParam int page,@RequestParam int size){
        return courseservice.getPage(page,size);
    }   

    @GetMapping("/get/title:{email}")
    public List<Courses> findByTitle(@PathVariable String email){
        return courseservice.findByTitle(email);
    }


    @GetMapping("/get/sortedbyname")
    public List<Courses> getSorted(){
        return courseservice.getSorted();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        courseservice.deleteStudent(id);
        return ResponseEntity.ok("Courses deleted Successfully");
    } 

    @PutMapping("/update/{id}")
    public ResponseEntity<Courses> updateStudent(@PathVariable Long id,@RequestBody Courses courses){
        Courses student1 = courseservice.updateStudent(id,courses);
        return ResponseEntity.ok(student1);
    }
}
