package com.dupy.F1.controller;

import com.dupy.F1.exception.EntityException;
import com.dupy.F1.model.Car;
import com.dupy.F1.model.Course;
import com.dupy.F1.model.Pilot;
import com.dupy.F1.service.ServiceCar;
import com.dupy.F1.service.ServiceCourse;
import com.dupy.F1.service.ServicePilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class index {
    @Autowired
    private ServicePilot servicePilot;
    @Autowired
    private ServiceCar serviceCar;
    @Autowired
    private ServiceCourse serviceCourse;

    @GetMapping("/pilot")
    public List<Pilot> pilots() {
        return servicePilot.findAll();
    }

    @GetMapping("/pilot/{id}")
    public Pilot pilot(@PathVariable int id) {
        Optional<Pilot> optional = servicePilot.find(id);
        return (Pilot) optional.orElse(new Pilot());
    }

    @PutMapping("/pilot")
    public Pilot save(@RequestBody Pilot pilot) {
        return servicePilot.save(pilot);
    }

    @PutMapping("/pilot/{id}")
    public Pilot edit(@PathVariable int id, @RequestBody Pilot pilot) {
        Optional<Pilot> optional = servicePilot.find(id);
        if (optional.isPresent()) {
            pilot.setId(id);
            return servicePilot.save(pilot);
        }
        throw new EntityException();
    }

    @DeleteMapping("/pilot/{id}")
    public Pilot delete(@PathVariable int id) {
        Optional<Pilot> optional = servicePilot.find(id);
        if (optional.isPresent()) {
            return servicePilot.findAll().remove(id);
        }
        throw new EntityException();
    }

    @GetMapping("/car")
    public List<Car> cars() {
        return serviceCar.findAll();
    }

    @GetMapping("/car/{id}")
    public Car car(@PathVariable int id) {
        Optional<Car> optional = serviceCar.find(id);
        return (Car) optional.orElse(new Car());
    }

    @PutMapping("/car")
    public Car save(@RequestBody Car car) {
        return serviceCar.save(car);
    }

    @PutMapping("/car/{id}")
    public Car edit(@PathVariable int id, @RequestBody Car car) {
        Optional<Car> optional = serviceCar.find(id);
        if (optional.isPresent()) {
            car.setId(id);
            return serviceCar.save(car);
        }
        throw new EntityException();
    }

    @PutMapping("/car/{id}/addPilot")
    public Car addPilot(@PathVariable int id, @RequestBody Pilot data) {
        Optional<Car> optional = serviceCar.find(id);
        if (optional.isPresent()) {
            Car car = optional.get();
            if (data.getId() > 0) {
                Optional<Pilot> optionalPilot = servicePilot.find(data.getId());
                if (optionalPilot.isPresent()) {
                    car.setPilot(optionalPilot.get());
                    return serviceCar.save(car);
                }
            }
        }
        throw new EntityException();
    }

    @PutMapping("/car/{id}/removePilot")
    public Car removePilot(@PathVariable int id, @RequestBody Pilot data) {
        Optional<Car> optional = serviceCar.find(id);
        if (optional.isPresent()) {
            Car car = optional.get();
            car.setPilot(null);
            return serviceCar.save(car);
        }
        throw new EntityException();
    }

    @DeleteMapping("/car/{id}")
    public Car delete(@PathVariable int id, @RequestBody Car car) {
        Optional<Car> optional = serviceCar.find(id);
        if (optional.isPresent()) {
            return serviceCar.findAll().remove(id);
        }
        throw new EntityException();
    }


    @GetMapping("/course")
    public List<Course> courses() {
        return serviceCourse.findAll();
    }

    @GetMapping("/course/{id}")
    public Course course(@PathVariable int id) {
        Optional<Course> optional = serviceCourse.find(id);
        return (Course) optional.orElse(new Course());
    }

    @PutMapping("/course")
    public Course save(@RequestBody Course course) {
        return serviceCourse.save(course);
    }

    @PutMapping("/course/{id}")
    public Course edit(@PathVariable int id, @RequestBody Course course) {
        Optional<Course> optional = serviceCourse.find(id);
        if (optional.isPresent()) {
            course.setId(id);
            return serviceCourse.save(course);
        }
        throw new EntityException();
    }

    @DeleteMapping("/course/{id}")
    public Course delete(@PathVariable int id, @RequestBody Course course) {
        Optional<Course> optional = serviceCourse.find(id);
        if (optional.isPresent()) {
            return serviceCourse.findAll().remove(id);
        }
        throw new EntityException();
    }
    @PutMapping("/course/{id}/addCar")
    public Course addCar(@PathVariable int id, @RequestBody Car data){
        Optional<Course> optional = serviceCourse.find(id);
        if (optional.isPresent()) {
            Course course = optional.get();
            if (data.getId() > 0) {
                Optional<Car> optionalCar = serviceCar.find(data.getId());
                if (optionalCar.isPresent()) {
                    Car car = optionalCar.get();
                    car.setCourse(course);
                    serviceCar.save(car);
                    return serviceCourse.find(id).get();
                }
            }
        }
        throw new EntityException();
    }

    @PutMapping("/course/{id}/removeCar")
    public Course removeCar(@PathVariable int id, @RequestBody Car data){
        if (data.getId() > 0) {
            Optional<Car> optional = serviceCar.find(data.getId());
            if (optional.isPresent()) {
                Car car = optional.get();
                Optional<Course> optionalCourse = serviceCourse.find(id);
                if (optionalCourse.isPresent()) {
                    Course course = optionalCourse.get();
                    if (Objects.equals(car.getCourse(), course)) {
                        car.setCourse(null);
                        serviceCar.save(car);
                        return serviceCourse.find(id).get();
                    }
                }
            }
        }
        throw new EntityException();
    }
}
