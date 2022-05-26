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
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    private String name;

    @OneToMany(mappedBy = "type")
    private Set<Wine> wines;

    public Type(String name) {
        this.name = name;
    }

    public void addWine(Wine w) {
        if (wines == null) {
            wines = new HashSet<>();
        }
        wines.add(w);
        w.setType(this);
    }

    public void removeWine(Wine w) {
        wines.remove(w);
        w.setType(null);
    }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Type)) return false;
        Type type = (Type) o;
        return Objects.equals(getId(), type.getId()) &&
               getName().equals(type.getName()) &&
               Objects.equals(getWines(), type.getWines());
    }

    @Override public int hashCode() {
        return Objects.hash(getId(), getName(), getWines());
    }

    @Override public String toString() {
        return "Type{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Type))
            return false;
        Type type = (Type) o;
        return Objects.equals(this.getId(), type.getId()) && Objects.equals(this.name, type.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.name);
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


