package br.com.gabriel.rmihello;

import br.com.gabriel.entities.Bicycle;
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
    Bicycle b1 = new Bicycle(1L, "Preta", 192.45);
    Bicycle b2 = new Bicycle(2L, "Vermelha", 192.45);
    Bicycle b3 = new Bicycle(3L, "Azul", 192.45);
    Bicycle b4 = new Bicycle(4L, "Verde", 192.45);
    Bicycle b5 = new Bicycle(5L, "Roxa", 192.45);
    
    biDao.create(b1, b2, b3, b4, b5);
  }
}
