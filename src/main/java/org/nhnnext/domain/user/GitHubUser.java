package org.nhnnext.domain.user;

import lombok.Data;
import org.nhnnext.domain.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue(value = UserType.Values.GITHUB)
public class GitHubUser extends User {

    private String name;
    private String accessToken;
}
