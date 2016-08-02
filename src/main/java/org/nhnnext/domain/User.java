package org.nhnnext.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Inheritance
@DiscriminatorColumn(name = "USER_TYPE")
public class User extends BaseEntity<User, Long> {

    @NotNull
    @Column(unique = true)
    private String username;

    @Override
    public void update(User entity) {
        setUsername(entity.getUsername());
    }
}
