package org.nhnnext.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Board extends AbstractPersistable<Long> {

    @NotNull
    private String name;

    private String desc;

    @OneToMany
    private java.util.List<List> lists;
}
