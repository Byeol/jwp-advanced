package org.nhnnext.web.actual;

import lombok.RequiredArgsConstructor;
import org.nhnnext.domain.user.LocalUser;
import org.nhnnext.service.actual.LocalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/api")
public class UserController {

    private final LocalUserService localUserService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public Principal getAuthenticatedUser(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody LocalUser user) {
        localUserService.save(user);
        return ResponseEntity.ok(user);
    }
}
