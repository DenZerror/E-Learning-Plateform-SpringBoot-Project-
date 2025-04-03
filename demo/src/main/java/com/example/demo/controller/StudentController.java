package com.example.demo.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.entity.Student;
import com.example.demo.service.StudentService;

import jakarta.transaction.Transactional;


@RestController
@Transactional
@RequestMapping("/student")


public class StudentController {
    @Autowired
    StudentService studservice;


    @PostMapping("/add")
    public Student addStudent(@RequestBody Student stud){
        return studservice.addStudent(stud);
    }
    


    @GetMapping("/get/all")
    public List<Student> getStudent(){
        return studservice.getStudent();
    }

    @GetMapping("/get/id:{id}")
    public Student getEmployeebyId(@PathVariable Long id){
        return studservice.findById(id);
    }

    @GetMapping("/get/name:{name}")
    public List<Student> getStudnetbyName(@PathVariable String name){
        return studservice.findByName(name);
    }

  
    @GetMapping("/student")
    public Page<Student> getPage(@RequestParam int page,@RequestParam int size){
        return studservice.getPage(page,size);
    }   

    @GetMapping("/get/email:{email}")
    public List<Student> findByEmail(@PathVariable String email){
        return studservice.findByEmail(email);
    }


    @GetMapping("/get/sortedbyname")
    public List<Student> getSorted(){
        return studservice.getSorted();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studservice.deleteStudent(id);
        return ResponseEntity.ok("Student deleted Successfully");
    } 

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student student){
        Student student1 = studservice.updateStudent(id,student);
        return ResponseEntity.ok(student1);
    }
}
