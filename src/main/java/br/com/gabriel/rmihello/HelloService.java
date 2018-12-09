package br.com.gabriel.rmihello;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author code
 */
public interface HelloService extends Remote {
  
  public String echo(String input) throws RemoteException;
}
