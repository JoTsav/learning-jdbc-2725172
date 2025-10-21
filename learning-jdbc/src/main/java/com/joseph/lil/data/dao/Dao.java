package com.joseph.lil.data.entity;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

public interface Dao<T, Id extends UUID> {
  // Defining interface methds for CRUD operations
  List<T> getAll();

  T create(T entity);

  Optional<T> getOne(UUID id);

  T update(T entity);

  void delete(Id id);
}