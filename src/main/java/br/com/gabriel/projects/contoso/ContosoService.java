package br.com.gabriel.projects.contoso;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author gabri
 */
public interface ContosoService extends Remote {

  void sendMessage(String message) throws RemoteException;
}
