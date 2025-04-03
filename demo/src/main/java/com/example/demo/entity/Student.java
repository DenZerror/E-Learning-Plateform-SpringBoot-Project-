package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String courses;

    @OneToMany(cascade=CascadeType.ALL , mappedBy = "student")
    List<Courses> courseList = new ArrayList<>();

    public Student() {
    }
    public Student(long id, String name, String email, String courses) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.courses = courses;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCourses() {
        return courses;
    }
    public void setCourses(String courses) {
        this.courses = courses;
    }
    public List<Courses> getCourseList() {
        return courseList;
    }
    public void setCourseList(List<Courses> courseList) {
        this.courseList = courseList;
    }
    
    
    
    
}