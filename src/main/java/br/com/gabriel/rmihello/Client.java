package br.com.gabriel.rmihello;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author code
 */
public class Client {
  
  public static void main(String[] args) {
    try {
      HelloService service = (HelloService) Naming.lookup("rmi://localhost:5099/hello");
      System.out.println("--- " + service.echo("Hey server"));
    } catch (RemoteException | NotBoundException | MalformedURLException ex) {
      System.out.println("Deu merda");
    }
  }
}
