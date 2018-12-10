package br.com.gabriel.entities;

import br.com.gabriel.enums.DeliveryStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.joda.time.LocalDate;

/**
 *
 * @author gabri
 */
public class Pedido implements Entity {

  private final List<Bicycle> bicycles;
  private final Long id;
  private final LocalDate toDeliver;
  private final DeliveryStatus status;
  private final String phoneNumber;
  
  public Pedido(Long id, String phoneNumber,Bicycle... bicycles) {
    this.id = id;
    this.phoneNumber = phoneNumber;
    this.bicycles = new ArrayList<>();
    this.bicycles.addAll(Arrays.asList(bicycles));
    this.toDeliver = LocalDate.now();
    this.toDeliver.plusDays(1);
    this.status = DeliveryStatus.PENDENT;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }
  
  public List<Bicycle> getBicycles() {
    return this.bicycles;
  }

  @Override
  public Long getId() {
    return this.id;
  }

  public LocalDate getToDeliver() {
    return this.toDeliver;
  }

  public DeliveryStatus getStatus() {
    return this.status;
  }
}
