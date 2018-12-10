package br.com.gabriel.projects.fabrikam;

import br.com.gabriel.entities.Pedido;
import br.com.gabriel.projects.contoso.ContosoService;
import br.com.gabriel.projects.duwawish.DuwawishService;
import br.com.gabriel.projects.duwawish.dao.Dao;
import br.com.gabriel.projects.duwawish.dao.DaoImpl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.joda.time.Days;

/**
 *
 * @author gabri
 */
public class Client {

  private static ScheduledExecutorService executorService;
  private static Dao<Pedido> peDao;

  public static void main(String[] args) {
    peDao = new DaoImpl<>(Pedido.class);
    executorService = Executors.newScheduledThreadPool(1);

    executorService.scheduleAtFixedRate(() -> {
      List<Pedido> pedidos = peDao.getAll();

      pedidos.forEach((pedido) -> {
        try {
          System.out.println("Verificando status dos pedidos...");
          DuwawishService service = (DuwawishService) Naming.lookup("rmi://localhost:5097/duwawish");
          Map<String, Days> data = service.getStatus(pedido.getId());
          
          Days deliverDay = data.values().iterator().next();
          
          if (deliverDay.getDays() <= 1){
            ContosoService contoso = (ContosoService) Naming.lookup("rmi://localhost:5098/contoso");
            contoso.sendMessage("Seu pedido será entregue daqui 1 dia!\nStatus: " + data.keySet().iterator().next());
          }
          
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
          System.out.println(ex.getMessage());
        }
      });

    }, 5, 5, TimeUnit.SECONDS);
  }
}
