package br.com.gabriel.enums;

/**
 *
 * @author gabri
 */
public enum DeliveryStatus {

  PENDENT("Pendente"),
  SENT("Enviado"),
  DELIVERED("Entregue");
  
  private String value;

  private DeliveryStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
