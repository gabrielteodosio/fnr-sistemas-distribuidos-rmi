package br.com.gabriel.projects.duwawish;

import br.com.gabriel.entities.Bicycle;
import br.com.gabriel.projects.duwawish.dao.Dao;
import br.com.gabriel.projects.duwawish.dao.DaoImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import org.joda.time.Days;
import org.joda.time.LocalDate;

/**
 *
 * @author gabri
 */
public class DuwawishServant extends UnicastRemoteObject implements DuwawishService {

  private Dao<Bicycle> dao = new DaoImpl<>(Bicycle.class);

  public DuwawishServant() throws RemoteException {
    super();
  }

  @Override
  public Map<String, Days> getStatus(Long id) throws RemoteException {
    Map<String, Days> bMap = new HashMap<>();

    Bicycle bicycle = dao.get(id);
    
    LocalDate now = new LocalDate();
    LocalDate bicycleDeliverDate = new LocalDate(bicycle.getToDeliver());
    Days days = Days.daysBetween(bicycleDeliverDate, now);
    
    bMap.put(
      bicycle.getId() + " - " + bicycle.getPrice() + " - cor: " + bicycle.getColor() + " [" + bicycle.getDeliveryStatus().getValue() + "]",
      days
    );

    return bMap;
  }
}
