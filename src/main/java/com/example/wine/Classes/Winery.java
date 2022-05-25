package com.example.wine.Classes;

import com.example.wine.Wine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Winery extends Wine {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Winery(String name) {
        this.name = name;
    }

    public Winery(String name, String year, float rating, int num_reviews, int price, int body, int acidity, String wineryName) {
        super(name, year, rating, num_reviews, price, body, acidity);
        this.name = wineryName;
    }

    public Winery() {

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}