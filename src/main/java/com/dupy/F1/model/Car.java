package com.dupy.F1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int speed;
    @Nullable
    @OneToOne
    private Pilot pilot;
    @Nullable
    @ManyToOne
    @JsonIgnore
    private Course course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(@Nullable Pilot pilot) {
        this.pilot = pilot;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
