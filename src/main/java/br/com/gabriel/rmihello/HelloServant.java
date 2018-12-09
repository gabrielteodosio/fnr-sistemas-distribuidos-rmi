package br.com.gabriel.rmihello;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author code
 */
public class HelloServant extends UnicastRemoteObject implements HelloService {

  public HelloServant() throws RemoteException {
    super();
  }

  @Override
  public String echo(String input) throws RemoteException {
    return "From server: " + input;
  }
}
