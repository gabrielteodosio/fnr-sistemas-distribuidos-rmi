package br.com.gabriel.projects.duwawish;

import br.com.gabriel.entities.Bicycle;
import br.com.gabriel.entities.Pedido;
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

  private Dao<Pedido> daoPedido = new DaoImpl<>(Pedido.class);

  public DuwawishServant() throws RemoteException {
    super();
  }

  @Override
  public Map<String, Days> getStatus(Long id) throws RemoteException {
    Map<String, Days> bMap = new HashMap<>();

    Pedido pedido = daoPedido.get(id);
    Bicycle bicycle = pedido.getBicycles().iterator().next();
    
    LocalDate now = new LocalDate();
    LocalDate bicycleDeliverDate = pedido.getToDeliver();
    
    Days days = Days.daysBetween(bicycleDeliverDate, now);
    
    bMap.put(
      bicycle.getId() + " - " + bicycle.getPrice() + " - cor: " + bicycle.getColor() + " [" + pedido.getStatus().getValue() + "]",
      days
    );

    return bMap;
  }
}
