package br.com.gabriel.projects.fabrikam;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author gabri
 */
public class ApplicationServer {

  public static void main(String[] args) throws RemoteException {
    Registry registry = LocateRegistry.createRegistry(5001);
    registry.rebind("hello", new FabrikamServant());
  }
}
