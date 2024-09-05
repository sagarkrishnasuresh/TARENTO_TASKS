package com.demo.CRUD_OPERATIONS;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Entity
public class Project{

    @Id
    private  int id;
    private String name;
    private int budget;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }








}
