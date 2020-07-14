package com.atestados.online.AtestadosOnline.Models;

import java.util.List;

import com.google.common.base.Optional;

public interface DAOCrud<T> {
    
    Optional<T> findById(Long id);
     
    List<T> findAll();
     
    T save(T t);
    
    T update(Long id, T entity);
     
    void deleteById(Long id);
}
