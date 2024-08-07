package com.dupy.F1.service;

import com.dupy.F1.dao.PilotRepository;
import com.dupy.F1.model.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePilot {
    @Autowired
    PilotRepository repository;
    public List<Pilot> findAll(){
        return (List<Pilot>) repository.findAll();
    }
    public Optional<Pilot> find(int id){
        return repository.findById(id);
    }

    public Pilot save(Pilot data) {
        return repository.save(data);
    }

}
