package br.com.gabriel.projects.adventureworks.dao;

import br.com.gabriel.entities.Bicycle;
import java.util.List;


/**
 *
 * @author gabri
 */
public interface Dao<T extends Bicycle> {

  void create(T obj);

  T get(Long id);

  void remove(Long id);

  void update(T obj);
  
  List<T> getAll();
}
