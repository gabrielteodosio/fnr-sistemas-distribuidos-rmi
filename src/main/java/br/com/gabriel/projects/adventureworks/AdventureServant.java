package br.com.gabriel.projects.adventureworks;

import br.com.gabriel.entities.Bicycle;
import br.com.gabriel.projects.adventureworks.dao.Dao;
import br.com.gabriel.projects.adventureworks.dao.DaoImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class AdventureServant extends UnicastRemoteObject implements AdventureService {

  private Dao<Bicycle> dao;
  
  public AdventureServant() throws RemoteException {
    super();
    dao = new DaoImpl<>(Bicycle.class);
  }

  @Override
  public void novoPedido() throws RemoteException {
    Scanner in = new Scanner(System.in);
    List<Bicycle> bikes = dao.getAll();
    
    System.out.println(" ====== Menu ====== ");
    bikes.forEach((b) -> {
      System.out.println(b.toString());
    });
    System.out.println("\nQual o modelo vc quer?");
  }

}
