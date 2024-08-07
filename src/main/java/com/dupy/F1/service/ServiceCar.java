package com.dupy.F1.service;

import com.dupy.F1.dao.CarRepository;
import com.dupy.F1.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCar {
    @Autowired
    CarRepository repository;

    public List<Car> findAll() {
        return (List<Car>) repository.findAll();
    }

    public Optional<Car> find(int id) {
        return repository.findById(id);
    }

    public Car save(Car data) {
        return repository.save(data);
    }

}
