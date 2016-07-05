package org.nhnnext.web.actual;

import org.nhnnext.domain.User;
import org.nhnnext.service.actual.UserService;
import org.nhnnext.web.RepositoryEntityController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController extends RepositoryEntityController<User, Long> {

    @Autowired
    public UserController(UserService repository) {
        super(repository);
    }
}
