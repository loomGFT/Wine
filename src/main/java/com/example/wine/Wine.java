package com.example.wine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Wine {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String year;
    private float rating;
    private int num_reviews;
    private int price;
    private int body;
    private int acidity;

    public Wine() {
    }

    public Wine(Long id, String name, String year, float rating, int num_reviews, int price, int body, int acidity) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.num_reviews = num_reviews;
        this.price = price;
        this.body = body;
        this.acidity = acidity;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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

    @Override
    public String toString() {
        return "Wineshop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                ", rating=" + rating +
                ", num_reviews=" + num_reviews +
                ", price=" + price +
                ", body=" + body +
                ", acidity=" + acidity +
                '}';
    }
}
