package org.nhnnext.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Comment extends BaseEntity<Comment, Long> {

    @NotNull
    private String text;

    @NotNull
    @ManyToOne
    private Card card;

    @Override
    public void update(Comment entity) {
        setText(entity.getText());
    }
}
