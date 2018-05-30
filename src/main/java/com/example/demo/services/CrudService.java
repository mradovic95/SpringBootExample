package com.example.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class CrudService<T, ID, R extends JpaRepository<T, ID>> {

    protected R repository;

    public CrudService(R repository) {
        this.repository = repository;
    }

    public Page<T> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public T getById(ID id) {
        Optional<T> entity = repository.findById(id);
        if (entity.isPresent()) {
            return entity.get();
        }
        return null;
    }

    public void add(T entity) {
        repository.save(entity);
    }

    public void delete(ID id) {
        repository.deleteById(id);
    }

    public void update(T entity) {
        repository.save(entity);
    }

    public R getRepository() {
        return repository;
    }

    public void setRepository(R repository) {
        this.repository = repository;
    }
}
