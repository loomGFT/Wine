package com.example.wine;

import com.example.wine.Classes.Region;
import com.example.wine.Classes.Type;
import com.example.wine.Classes.Winery;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Wine {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int wineYear;
    private float rating;
    private int num_reviews;
    private int price;
    private int body;
    private int acidity;

    @ManyToOne
    @JoinColumn(name = "region")
    private Region region;
    @ManyToOne
    @JoinColumn(name = "type")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "winery")
    private Winery winery;

    public Wine() {
    }

    public Wine(String name, int year, float rating, int num_reviews, int price, int body, int acidity, Region region, Type type, Winery winery) {
        this.name = name;
        this.wineYear = year;
        this.rating = rating;
        this.num_reviews = num_reviews;
        this.price = price;
        this.body = body;
        this.acidity = acidity;
        this.region = region;
        this.type = type;
        this.winery = winery;
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

    public int getYear() {
        return wineYear;
    }

    public void setYear(int year) {
        this.wineYear = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getNum_reviews() {
        return num_reviews;
    }

    public void setNum_reviews(int num_reviews) {
        this.num_reviews = num_reviews;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public int getAcidity() {
        return acidity;
    }

    public void setAcidity(int acidity) {
        this.acidity = acidity;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Winery getWinery() {
        return winery;
    }

    public void setWinery(Winery winery) {
        this.winery = winery;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Wine))
            return false;
        Wine wine = (Wine) o;
        return Objects.equals(this.getId(), wine.getId()) && Objects.equals(this.winery, wine.winery)
                && Objects.equals(this.wineYear, wine.wineYear) && Objects.equals(this.region, wine.region)
                && Objects.equals(this.price, wine.price) && Objects.equals(this.name, wine.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.winery, this.wineYear, this.region, this.price, this.name);
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + wineYear + '\'' +
                ", rating=" + rating +
                ", num_reviews=" + num_reviews +
                ", price=" + price +
                ", body=" + body +
                ", acidity=" + acidity +
                ", region=" + region +
                ", type=" + type +
                ", winery=" + winery +
                '}';
    }
}
