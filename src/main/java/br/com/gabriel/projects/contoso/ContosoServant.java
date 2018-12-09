package br.com.gabriel.projects.contoso;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author gabri
 */
public class ContosoServant extends UnicastRemoteObject implements ContosoService {

  public ContosoServant() throws RemoteException {
    super();
  }

  @Override
  public void sendMessage(String message) {
    System.out.println("sent message:\n\'" + message + "\'\n");
  }
}
