package br.com.gabriel.projects.duwawish.dao;

import br.com.gabriel.entities.Bicycle;


/**
 *
 * @author gabri
 */
public interface Dao<T extends Bicycle> {

  void create(T obj);

  T get(Long id);

  void remove(Long id);

  void update(T obj);
}
