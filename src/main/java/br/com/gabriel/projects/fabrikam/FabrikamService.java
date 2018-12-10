package br.com.gabriel.projects.fabrikam;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import org.joda.time.Days;

/**
 *
 * @author gabri
 */
public interface FabrikamService extends Remote {
  void novoPedido(Long option, String phoneNumber) throws RemoteException;
  Map<String, Days> getStatus(long id) throws RemoteException;
}
