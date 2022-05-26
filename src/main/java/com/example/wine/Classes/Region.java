package com.example.wine.Classes;

import com.example.wine.Wine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Region {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String country;

    public Region(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Region(Long id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Region() {

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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Region))
            return false;
        Region region = (Region) o;
        return Objects.equals(this.getId(), region.getId()) && Objects.equals(this.name, region.name)
                && Objects.equals(this.country, region.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.name, this.country);
    }

    @Override
    public String toString() {
        return "Region{" + "id=" + this.getId() + ", Region='" + this.name + '\'' + ", country='" + this.country + '\'' + '}';
    }
}