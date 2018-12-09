package br.com.gabriel.rmihello;

import br.com.gabriel.entities.Bicycle;
import br.com.gabriel.enums.DeliveryStatus;
import br.com.gabriel.projects.duwawish.dao.Dao;
import br.com.gabriel.projects.duwawish.dao.DaoImpl;
import java.util.Date;
import org.joda.time.LocalDate;

/**
 *
 * @author gabri
 */
public class GenerateDatabase {

  public static void main(String[] args) {
    LocalDate today = LocalDate.fromDateFields(new Date());
    today.plusDays(10);
    
    Dao<Bicycle> biDao = new DaoImpl<>(Bicycle.class);
    
    Bicycle b1 = new Bicycle(1L, "Preta", 192.45, today.toDate(), DeliveryStatus.DELIVERED);
    
  }
}
