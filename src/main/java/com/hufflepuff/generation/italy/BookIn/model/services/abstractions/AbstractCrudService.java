package com.hufflepuff.generation.italy.BookIn.model.services.abstractions;

import org.springframework.stereotype.Service;

import java.util.Optional;

public interface AbstractCrudService<T> {
   Iterable<T> findAll();
   Optional<T> findById(long Id);
   T create(T entity);
   void update(T entity);
   void deleteById(long id);
}
