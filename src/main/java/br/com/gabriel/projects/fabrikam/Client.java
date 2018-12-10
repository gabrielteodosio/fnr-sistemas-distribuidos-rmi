package br.com.gabriel.projects.fabrikam;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author gabri
 */
public class Client {

  private static ScheduledExecutorService executorService;
  
  public static void main(String[] args) {
    executorService = Executors.newScheduledThreadPool(1);
    
    ScheduledFuture<?> future = executorService.schedule(() -> {
      try {
        FabrikamService service = (FabrikamService) Naming.lookup("rmi://localhost:5099/fabrikam");
        
      } catch (NotBoundException | MalformedURLException | RemoteException ex) {
        System.out.println(ex.getMessage());
      }
    }, 10, TimeUnit.SECONDS);
  }
}
