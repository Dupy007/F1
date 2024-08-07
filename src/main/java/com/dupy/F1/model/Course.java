package com.dupy.F1.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
public class Course {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String pays;
    @OneToMany(mappedBy = "course")
    private List<Car> cars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<Car> getCars() {
        return cars;
    }
}
