package com.cms.service;

import java.util.Optional;

public interface CrudService<T, ID> {

    Iterable<T> getAll();

    Iterable<T> getByIds(Iterable<ID> ids);

    Optional<T> getById(ID id);

    Optional<T> create(T entity);

    Optional<T> update(ID id, T entity);

    void delete(ID id);

    boolean existById(ID id);
}
