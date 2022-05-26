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
public class Winery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String name;

    @OneToMany(mappedBy = "winery")
    private Set<Wine> wines;

    public Winery(String name) {
        this.name = name;
    }

    public void addWine(Wine w) {
        if (wines == null) {
            wines = new HashSet<>();
        }
        wines.add(w);
        w.setWinery(this);

    }

    public void removeWine(Wine w) {
        wines.remove(w);
        w.setWinery(null);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Winery)) return false;
        Winery winery = (Winery) o;
        return Objects.equals(getId(), winery.getId()) &&
               getName().equals(winery.getName()) &&
               Objects.equals(getWines(), winery.getWines());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getName(), getWines());
    }

    @Override public String toString() {
        return "Winery{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';

    }
}