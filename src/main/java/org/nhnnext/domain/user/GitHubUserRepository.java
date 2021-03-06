package org.nhnnext.domain.user;

import org.springframework.data.repository.CrudRepository;

public interface GitHubUserRepository extends CrudRepository<GitHubUser, Long> {

    GitHubUser findByAccessToken(String accessToken);
    GitHubUser findByUsername(String username);
}
