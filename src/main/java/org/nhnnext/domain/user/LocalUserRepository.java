package org.nhnnext.domain.user;

import org.springframework.data.repository.CrudRepository;

public interface LocalUserRepository extends CrudRepository<LocalUser, Long> {

    LocalUser findByUsername(String username);
}
