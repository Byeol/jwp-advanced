package org.nhnnext.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Card extends BaseEntity<Card, Long> {

    @NotNull
    private String name;

    private String desc;

    @JsonIgnore
    @NotNull
    @ManyToOne
    private List list;

    @Override
    public void update(Card entity) {
        setName(entity.getName());
        setDesc(entity.getDesc());
    }
}
