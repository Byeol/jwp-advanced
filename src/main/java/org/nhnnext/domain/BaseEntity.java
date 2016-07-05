package org.nhnnext.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;

public abstract class BaseEntity<T, ID extends Serializable> extends AbstractPersistable<ID> {
    public abstract void update(T entity);
}
