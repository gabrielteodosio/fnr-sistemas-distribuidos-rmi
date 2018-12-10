package br.com.gabriel.entities;

import java.io.Serializable;

/**
 *
 * @author gabri
 */
public class Bicycle implements Entity, Serializable {

  private final Long id;
  private String color;
  private Double price;

  public Bicycle(Long id) {
    this.id = id;
  }

  public Bicycle(Long id, String color, Double price) {
    this.id = id;
    this.color = color;
    this.price = price;
  }
  
  public Long getId() {
    return id;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
