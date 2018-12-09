package br.com.gabriel.entities;

import br.com.gabriel.enums.DeliveryStatus;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author gabri
 */
public class Bicycle implements Serializable {

  private final Long id;
  private String color;
  private Double price;
  private Date toDeliver;
  private DeliveryStatus deliveryStatus;

  public Bicycle(Long id) {
    this.id = id;
  }

  public Bicycle(Long id, String color, Double price, Date toDeliver) {
    this.id = id;
    this.color = color;
    this.price = price;
    this.toDeliver = toDeliver;
    this.deliveryStatus = DeliveryStatus.PENDENT;
  }
  
  public Bicycle(Long id, String color, Double price, Date toDeliver, DeliveryStatus deliveryStatus) {
    this.id = id;
    this.color = color;
    this.price = price;
    this.toDeliver = toDeliver;
    this.deliveryStatus = deliveryStatus;
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

  public Date getToDeliver() {
    return toDeliver;
  }

  public void setToDeliver(Date toDeliver) {
    this.toDeliver = toDeliver;
  }

  public DeliveryStatus getDeliveryStatus() {
    return deliveryStatus;
  }

  public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
    this.deliveryStatus = deliveryStatus;
  }
}
