package org.nhnnext.domain.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.nhnnext.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Data
@Entity
@DiscriminatorValue(value = UserType.Values.LOCAL)
public class LocalUser extends User {

    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public void setPassword(PasswordEncoder passwordEncoder, String rawPassword) {
        setPassword(passwordEncoder.encode(rawPassword));
    }
}
