package com.example.wine.Classes;

import com.example.wine.Wine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Winery {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Winery(String name) {
        this.name = name;
    }

    public Winery() {

    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }
}