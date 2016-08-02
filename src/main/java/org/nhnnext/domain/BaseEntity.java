package org.nhnnext.domain;

import org.springframework.data.jpa.domain.AbstractAuditable;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@EntityListeners(value = AuditingEntityListener.class)
public abstract class BaseEntity<T, ID extends Serializable> extends AbstractAuditable<T, ID> {
    public abstract void update(T entity);
}
