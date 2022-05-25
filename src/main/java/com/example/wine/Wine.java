package com.example.wine;

import com.example.wine.Classes.Region;
import com.example.wine.Classes.Type;
import com.example.wine.Classes.Winery;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
@Table(name = "WINE")
@NoArgsConstructor
public class Wine {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private int    wineYear;
  private float  rating;
  private int    num_reviews;
  private int    price;
  private int    body;
  private int    acidity;

  @ManyToOne()
  @JoinColumn(name = "region_id")
  private Region region;

  @ManyToOne()
  @JoinColumn(name = "type_id")
  private Type type;

  @ManyToOne()
  @JoinColumn(name = "winery_id")
  private Winery winery;

  public Wine(String name, int wineYear, float rating, int num_reviews, int price, int body, int acidity) {
    this.name        = name;
    this.wineYear    = wineYear;
    this.rating      = rating;
    this.num_reviews = num_reviews;
    this.price       = price;
    this.body        = body;
    this.acidity     = acidity;
  }

  @Override public String toString() {
    return "Wine{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", wineYear=" + wineYear +
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
