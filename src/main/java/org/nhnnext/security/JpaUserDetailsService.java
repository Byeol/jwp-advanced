package org.nhnnext.security;

import lombok.RequiredArgsConstructor;
import org.nhnnext.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.nhnnext.domain.User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(MessageFormat.format("Username {0} not found", username));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
    }
}