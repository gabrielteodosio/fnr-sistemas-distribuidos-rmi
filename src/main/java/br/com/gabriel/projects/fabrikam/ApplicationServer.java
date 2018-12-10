package br.com.gabriel.projects.fabrikam;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author gabri
 */
public class ApplicationServer {

  public static void main(String[] args) {
    Integer port = 5099;
    String name = "fabri";
    
    try {
      System.out.println(name + " running on port: " + port);
      
      Registry registry = LocateRegistry.createRegistry(port);
      registry.rebind(name, new FabrikamServant());
      
    } catch (RemoteException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
