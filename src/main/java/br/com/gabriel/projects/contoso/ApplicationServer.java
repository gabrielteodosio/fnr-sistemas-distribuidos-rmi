package br.com.gabriel.projects.contoso;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class ApplicationServer {

  public static void main(String[] args) {
    Integer port = 5098;
    String name = "contoso";
    
    try {
      System.out.println(name + " running on port: " + port);
      Registry registry = LocateRegistry.createRegistry(port);
      registry.rebind(name, new ContosoServant());
    } catch (RemoteException ex) {
      Logger.getLogger(br.com.gabriel.projects.fabrikam.ApplicationServer.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
