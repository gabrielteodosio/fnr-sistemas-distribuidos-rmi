package br.com.gabriel.projects.duwawish;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author gabri
 */
public class ApplicationServer {

  public static void main(String[] args) {
    Integer port = 5097;
    String name = "duwawish";
    
    try {
      System.out.println(name + " running on port: " + port);
      Registry registry = LocateRegistry.createRegistry(port);
      registry.rebind(name, new DuwawishServant());
    } catch (RemoteException ex) {
      System.out.println("Deu merda");
    }
  }
}
