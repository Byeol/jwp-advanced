package org.nhnnext.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Card extends AbstractPersistable<Long> {

    @NotNull
    private String name;

    private String desc;

    @JsonIgnore
    @NotNull
    @ManyToOne
    private List list;
}
