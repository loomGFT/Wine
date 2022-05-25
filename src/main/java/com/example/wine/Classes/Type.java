package com.example.wine.Classes;

import com.example.wine.Wine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Type extends Wine {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Type(String name, String year, float rating, int num_reviews, int price, int body, int acidity,String typeName) {
        super(name, year, rating, num_reviews, price, body, acidity);
        this.name = typeName;
    }

    public Type() {

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

    @Override
    public String toString() {
        return "Type{" +
                "name='" + name + '\'' +
                '}';
    }
}
