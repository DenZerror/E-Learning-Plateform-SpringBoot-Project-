package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Trainers;
import com.example.demo.repository.TrainerRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TrainerService {
    @Autowired
    TrainerRepo trainerRepo;

    public Trainers addTrainer(Trainers trainer){
        return trainerRepo.save(trainer);
    }
    
    public List<Trainers> getTrainer(){
        return trainerRepo.findAll();
    }

    public Trainers findById(Long id){
        return trainerRepo.findById(id).orElse(null);
    }

    public List<Trainers> findByTrainerName(String name){
        return trainerRepo.findByTrainerName(name);
    }

    public Page<Trainers> getPage(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return trainerRepo.findAll(pageable);
    }

    public List<Trainers> getSorted(){
        return trainerRepo.findAll(Sort.by(Sort.Direction.ASC,"name"));
    }

    public List<Trainers> findByEmail(String email){
        return trainerRepo.findByEmail(email);
    }

    public void deleteTrainer(Long id){
        if(trainerRepo.existsById(id)){
            trainerRepo.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Trainers not found");
        }
    }
    
    public Trainers updateTrainer(Long id,Trainers tr){
        Trainers trainer = trainerRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Trainers not found"));
        tr.setId(id);
        trainer.setId(tr.getId());
        trainer.setTrainerName(tr.getTrainerName());
        trainer.setEmail(tr.getEmail());
        trainer.setStartDate(tr.getStartDate());
        trainer.setEndDate(tr.getEndDate());
        trainer.setCourse(tr.getCourse());
        trainer.setAssignedCourses(tr.getAssignedCourses());
       
        return trainerRepo.save(trainer);
    }
}
