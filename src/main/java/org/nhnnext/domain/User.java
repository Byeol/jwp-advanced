package org.nhnnext.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import static com.fasterxml.jackson.annotation.JsonProperty.*;

@Data
@Entity
public class User extends BaseEntity<User, Long> {

    @NotNull
    private String username;

    @NotNull
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    public void setPassword(PasswordEncoder passwordEncoder, String rawPassword) {
        setPassword(passwordEncoder.encode(rawPassword));
    }

    @Override
    public void update(User entity) {
        setUsername(entity.getUsername());
        setPassword(entity.getPassword());
    }
}
