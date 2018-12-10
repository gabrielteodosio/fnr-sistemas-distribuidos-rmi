package br.com.gabriel.projects.fabrikam;

import br.com.gabriel.enums.DeliveryStatus;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author gabri
 */
public interface FabrikamService extends Remote {
  void novoPedido(Long option, String phoneNumber) throws RemoteException;
  DeliveryStatus getStatus(long id) throws RemoteException;
}
