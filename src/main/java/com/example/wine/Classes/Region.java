package com.example.wine.Classes;

import com.example.wine.Wine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Region extends Wine {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;

    public Region(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Region(String name, String year, float rating, int num_reviews, int price, int body, int acidity, String regionName, String country) {
        super(name, year, rating, num_reviews, price, body, acidity);
        this.name = regionName;
        this.country = country;
    }

    public Region() {

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}