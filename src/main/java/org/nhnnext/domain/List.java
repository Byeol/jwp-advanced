package org.nhnnext.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class List extends AbstractPersistable<Long> {

    @NotNull
    private String name;

    @JsonIgnore
    @NotNull
    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "list")
    private java.util.List<Card> cards;
}
