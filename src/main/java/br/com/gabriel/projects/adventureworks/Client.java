package br.com.gabriel.projects.adventureworks;

import br.com.gabriel.entities.Bicycle;
import br.com.gabriel.enums.DeliveryStatus;
import br.com.gabriel.projects.duwawish.dao.Dao;
import br.com.gabriel.projects.duwawish.dao.DaoImpl;
import br.com.gabriel.projects.fabrikam.FabrikamService;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author gabri
 */
public class Client {

  private static Dao<Bicycle> dao;

  public static void main(String[] args) {
    try {
      dao = new DaoImpl<>(Bicycle.class);
      Scanner in = new Scanner(System.in);
      List<Bicycle> bikes = dao.getAll();
      boolean running = true;

      while (running) {
        System.out.println("\t====== Menu ====== ");

        bikes.forEach((bike) -> {
          System.out.println("*\t[#" + bike.getId() + "]. " + bike.getColor() + " [" + "];");
        });

        System.out.print("\nQual o modelo vc quer?\n> ");
        String input = in.nextLine();
        Long option = Long.parseLong(input);

        // Ask for exiting
        if (input.trim().equalsIgnoreCase("sair")) {
          System.out.println("Saindo");
          System.exit(0);
        }

        // Ask for order status
        if (input.trim().equalsIgnoreCase("status") || input.trim().equalsIgnoreCase("sts")) {
          System.out.print("Qual o id de seu pedido\n> ");
          input = in.nextLine();

          // Gets order status
          FabrikamService service = (FabrikamService) Naming.lookup("rmi://localhost:5099/fabrikam");
          DeliveryStatus status = service.getStatus(Long.parseLong(input));
          System.out.println("Status de seu pedido [#" + input + "] -> " + status.getValue());
          continue;
        }

        // Ask for telephone number
        System.out.print("\nQual seu telefone\n> ");
        input = in.nextLine();

        System.out.println("Opção selecionada: #" + option + "; Telefone: " + input + ";");

        // Creates new order
        FabrikamService service = (FabrikamService) Naming.lookup("rmi://localhost:5099/fabri");
        service.novoPedido(option, input);

        System.out.println("\t====== New Order! [#" + option + "] ====== ");
      }
    } catch (NotBoundException | MalformedURLException | RemoteException ex) {
      System.out.println(ex.getMessage());
    }
  }
}
