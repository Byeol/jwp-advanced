package org.nhnnext.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BaseService<T, ID extends Serializable> {

    private final CrudRepository<T, ID> repository;

    public T save(T entity) {
        return repository.save(entity);
    }

    public T findOne(ID id) {
        return repository.findOne(id);
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public void delete(T entity) {
        repository.delete(entity);
    }
}
