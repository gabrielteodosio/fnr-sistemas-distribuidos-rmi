package br.com.gabriel.projects.fabrikam;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author gabri
 */
public class FabrikamServant extends UnicastRemoteObject implements FabrikamService {

  public FabrikamServant() throws RemoteException {
    super();
  }
}
