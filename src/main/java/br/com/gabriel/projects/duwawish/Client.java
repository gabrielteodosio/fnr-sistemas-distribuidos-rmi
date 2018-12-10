package br.com.gabriel.projects.duwawish;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author gabri
 */
public class Client {

  public static void main(String[] args) {
    try {
      DuwawishService service = (DuwawishService) Naming.lookup("rmi://localhost:5099/duwawish");
    } catch (RemoteException | NotBoundException | MalformedURLException ex) {
      System.out.println("Deu merda");
    }
  }
}
