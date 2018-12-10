package br.com.gabriel.projects.duwawish.dao;

import br.com.gabriel.entities.Entity;
import java.util.List;


/**
 *
 * @author gabri
 */
public interface Dao<T extends Entity> {

  void create(T obj);
  void create(T... obj);

  T get(Long id);

  void remove(Long id);

  void update(T obj);
  
  List<T> getAll();
}
