package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Courses;
import com.example.demo.repository.CourseRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CourseService {
    @Autowired
    CourseRepo courseRepo;

    public Courses addCourses(Courses courses){
        return courseRepo.save(courses);
    }
    public List<Courses> getCourses(){
        return courseRepo.findAll();
    }

    public Courses findById(Long id){
        return courseRepo.findById(id).orElse(null);
    }

    public List<Courses> findByTitle(String name){
        return courseRepo.findByTitle(name);
    }

    public Page<Courses> getPage(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return courseRepo.findAll(pageable);
    }


    public List<Courses> getSorted(){
        return courseRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
    }

    public List<Courses> findByTrainer(String email){
        return courseRepo.findByTrainer(email);
    }

    public void deleteStudent(Long id){
        if(courseRepo.existsById(id)){
            courseRepo.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Courses not found");
        }
    }
    
    public Courses updateStudent(Long id,Courses cr){
        Courses courses = courseRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Courses not found"));
        cr.setId(id);
        courses.setId(cr.getId());
        courses.setTitle(cr.getTitle());
        courses.setDescription(cr.getDescription());
        courses.setTrainer(cr.getTrainer());
       
        return courseRepo.save(cr);
    }
}
