package com.dupy.F1.dao;

import com.dupy.F1.model.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Integer> {
}
