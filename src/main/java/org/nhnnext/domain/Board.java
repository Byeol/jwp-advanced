package org.nhnnext.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Board extends BaseEntity<Board, Long> {

    @NotNull
    private String name;

    private String desc;

    @OneToMany(mappedBy = "board")
    private java.util.List<List> lists;

    @Override
    public void update(Board entity) {
        setName(entity.getName());
        setDesc(entity.getDesc());
    }
}
