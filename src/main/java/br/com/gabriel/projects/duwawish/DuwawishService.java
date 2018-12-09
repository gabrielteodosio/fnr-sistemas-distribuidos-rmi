package br.com.gabriel.projects.duwawish;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;
import org.joda.time.Days;

/**
 *
 * @author gabri
 */
public interface DuwawishService extends Remote {

  public Map<String, Days> getStatus(Long id) throws RemoteException;
}
