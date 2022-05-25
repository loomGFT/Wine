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
}