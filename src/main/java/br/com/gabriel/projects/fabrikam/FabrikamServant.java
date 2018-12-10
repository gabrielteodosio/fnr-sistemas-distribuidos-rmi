/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gabriel.projects.fabrikam;

import br.com.gabriel.entities.Bicycle;
import br.com.gabriel.entities.Pedido;
import br.com.gabriel.enums.DeliveryStatus;
import br.com.gabriel.projects.duwawish.dao.Dao;
import br.com.gabriel.projects.duwawish.dao.DaoImpl;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author code
 */
public class FabrikamServant extends UnicastRemoteObject implements FabrikamService {

  private final Dao<Bicycle> biDao;
  private final Dao<Pedido> peDao;
  private final ScheduledExecutorService scheduledExecutorService;

  public FabrikamServant() throws RemoteException {
    super();
    biDao = new DaoImpl<>(Bicycle.class);
    peDao = new DaoImpl<>(Pedido.class);
    scheduledExecutorService = Executors.newScheduledThreadPool(5);
  }

  @Override
  public void novoPedido(Long option, String phoneNumber) {
    scheduledExecutorService.execute(() -> {
      Bicycle bike = biDao.get(option);

      Long nowDateTime = Calendar.getInstance().getTimeInMillis();
      Pedido pedido = new Pedido(nowDateTime, phoneNumber, bike);
      peDao.create(pedido);

      try {
        Thread.sleep(8000);
      } catch (InterruptedException ex) {
        System.out.println(ex.getMessage());
      }

      System.out.println("Pedido criado com sucesso! [#" + pedido.getId() + "]");
    });
  }

  @Override
  public DeliveryStatus getStatus(long id) {
    Pedido pedido = peDao.get(id);
    return pedido.getStatus();
  }
}
