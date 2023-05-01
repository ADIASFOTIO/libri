package com.hufflepuff.generation.italy.BookIn.model.services.implementations;

import com.hufflepuff.generation.italy.BookIn.model.data.abstractions.GenericRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public class GenericCrudService<T> {
   private GenericRepository<T> repo;

   public GenericCrudService(GenericRepository<T> repo){
      this.repo = repo;
   }
   public void setRepo(GenericRepository repo){
      this.repo = repo;
   }
   public List<T> findAll(){
      return repo.findAll();
   }
   public Optional<T> findById(long id){
      return repo.findById(id);
   }
   @Transactional
   public T create(T entity){
      return repo.save(entity);
   }
   @Transactional
   public T update(T entity){
      return repo.save(entity);
   }
   @Transactional
   public void deleteById(long id){
      repo.deleteById(id);
   }
}
