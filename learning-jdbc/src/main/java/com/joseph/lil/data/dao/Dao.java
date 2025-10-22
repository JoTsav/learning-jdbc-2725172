package com.joseph.lil.data.dao;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

/**
 * @author jotsh
 * @param <T>
 * @param <Id>
 *     Dao interface describes the operations that can be performed with a database
 */

public interface Dao<T, Id extends UUID> {
  // Defining interface methds for CRUD operations
  List<T> getAll();

  T create(T entity);

  Optional<T> getOne(UUID id);

  T update(T entity);

  void delete(Id id);
}