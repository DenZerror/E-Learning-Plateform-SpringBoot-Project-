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

import com.example.demo.entity.Trainers;
import com.example.demo.service.TrainerService;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    @Autowired
    TrainerService trainerService;

    @PostMapping("/add")
    public Trainers addTrainer(@RequestBody Trainers stud){
        return trainerService.addTrainer(stud);
    }
    

    @GetMapping("/get/all")
    public List<Trainers> getTrainer(){
        return trainerService.getTrainer();
    }

    @GetMapping("/get/id:{id}")
    public Trainers getTrainerbyId(@PathVariable Long id){
        return trainerService.findById(id);
    }

    @GetMapping("/get/name:{name}")
    public List<Trainers> getTrainerbyName(@PathVariable String name){
        return trainerService.findByTrainerName(name);
    }

  
    @GetMapping("/trainer")
    public Page<Trainers> getPage(@RequestParam int page,@RequestParam int size){
        return trainerService.getPage(page,size);
    }   

    @GetMapping("/get/email:{email}")
    public List<Trainers> findByEmail(@PathVariable String email){
        return trainerService.findByEmail(email);
    }


    @GetMapping("/get/sortedbyname")
    public List<Trainers> getSorted(){
        return trainerService.getSorted();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTrainer(@PathVariable Long id){
        trainerService.deleteTrainer(id);
        return ResponseEntity.ok("Trainers deleted Successfully");
    } 

    @PutMapping("/update/{id}")
    public ResponseEntity<Trainers> updateTrainer(@PathVariable Long id,@RequestBody Trainers trainer){
        Trainers trainers = trainerService.updateTrainer(id,trainer);
        return ResponseEntity.ok(trainers);
    }
}

