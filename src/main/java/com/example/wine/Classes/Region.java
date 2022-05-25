package com.example.wine.Classes;

import com.example.wine.Wine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long      id;
    private String    name;
    private String    country;
    @OneToMany(mappedBy = "region")
    private Set<Wine> wines;

    public Region(String name, String country) {
        this.name    = name;
        this.country = country;
    }

    public void addWine(Wine wine) {
        if (wines == null) {
            wines = new HashSet<>();
        }
        wines.add(wine);
        wine.setRegion(this);
    }

    public void removeWine(Wine wine) {
        wines.remove(wine);
        wine.setRegion(null);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Region)) return false;
        Region region = (Region) o;
        return Objects.equals(getId(), region.getId()) && getName().equals(region.getName()) && getCountry().equals(
            region.getCountry()) && Objects.equals(getWines(), region.getWines());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getName(), getCountry(), getWines());
    }

    @Override public String toString() {
        return "Region{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", country='" + country + '\'' +
               '}';
    }
}