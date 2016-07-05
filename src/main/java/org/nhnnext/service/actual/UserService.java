package org.nhnnext.service.actual;

import org.nhnnext.domain.User;
import org.nhnnext.domain.UserRepository;
import org.nhnnext.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseService<User, Long> {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User entity) {
        if (entity.isNew()) {
            entity.setPassword(passwordEncoder, entity.getPassword());
        }

        return super.save(entity);
    }
}
