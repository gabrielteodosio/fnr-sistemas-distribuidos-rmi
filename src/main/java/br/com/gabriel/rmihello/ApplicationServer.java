package br.com.gabriel.rmihello;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author code
 */
public class ApplicationServer {
  
  public static void main(String[] args) {
    try {
      Registry registry = LocateRegistry.createRegistry(5098);
      registry.rebind("hello", new HelloServant());
    } catch (RemoteException ex) {
      System.out.println("Deu merda");
    }
  }
}
