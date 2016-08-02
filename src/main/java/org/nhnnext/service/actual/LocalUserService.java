package org.nhnnext.service.actual;

import org.nhnnext.domain.user.LocalUser;
import org.nhnnext.domain.user.LocalUserRepository;
import org.nhnnext.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LocalUserService extends BaseService<LocalUser, Long> {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LocalUserService(LocalUserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public LocalUser save(LocalUser entity) {
        if (entity.isNew()) {
            entity.setPassword(passwordEncoder, entity.getPassword());
        }

        return super.save(entity);
    }
}
