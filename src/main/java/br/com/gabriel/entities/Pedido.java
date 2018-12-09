package br.com.gabriel.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gabri
 */
public class Pedido implements Entity {

  private List<Bicycle> bicycles;
  private Integer id;
  
  public Pedido(Bicycle... bicycles) {
    this.bicycles = Arrays.asList(bicycles);
  }

  public List<Bicycle> getBicycles() {
    return bicycles;
  }

  @Override
  public Integer getId() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
