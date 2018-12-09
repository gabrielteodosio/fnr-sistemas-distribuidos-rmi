package br.com.gabriel.projects.adventureworks.dao;

import br.com.gabriel.entities.Bicycle;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author gabri
 */
public class DaoImpl<T extends Bicycle> implements Dao<T> {

  private ArquivoUtil<T> util;
  private Class<? extends T> clazz;

  public DaoImpl(Class<? extends T> clazz) {
    this.clazz = clazz;
    util = new ArquivoUtil<>(this.clazz);
  }

  @Override
  public void create(T obj) {
    List<T> objs = util.read();
    objs.add(obj);
    util.write(objs);
  }

  @Override
  public T get(Long id) {
    List<T> objs = util.read();
    Iterator<T> iterator = objs.iterator();
    return get(id, iterator, 1);
  }

  private T get(Long id, Iterator<T> iterator, int operation) {
    T placeholder = null;

    while (iterator.hasNext()) {
      placeholder = iterator.next();

      if (placeholder.getId().equals(id)) {
        if (operation == 1) {
          return placeholder;
        } else if (operation == 0) {
          iterator.remove();
        }
      }
    }

    return placeholder;
  }

  @Override
  public void remove(Long id) {
    List<T> objs = util.read();
    Iterator<T> iterator = objs.iterator();
    get(id, iterator, 0);
  }

  @Override
  public void update(T obj) {
    remove(obj.getId());
    create(obj);
  }

  @Override
  public List<T> getAll() {
    return util.read();
  }
}
