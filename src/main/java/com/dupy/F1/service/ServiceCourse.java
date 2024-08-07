package com.dupy.F1.service;

import com.dupy.F1.dao.CourseRepository;
import com.dupy.F1.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCourse {
    @Autowired
    CourseRepository repository;

    public List<Course> findAll() {
        return (List<Course>) repository.findAll();
    }

    public Optional<Course> find(int id) {
        return repository.findById(id);
    }

    public Course save(Course data) {
        return repository.save(data);
    }

}
