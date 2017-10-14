package pk.com.habsoft.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pk.com.habsoft.model.security.User;
import pk.com.habsoft.security.JwtUserFactory;
import pk.com.habsoft.security.repository.UserRepository;

/**
 * Created by stephan on 20.03.16.
 */
@Service
public class JwtUserManagerImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println(userRepository.findAll());

        User user = userRepository.findByUsername(username);
        System.out.println("Load user : " + user);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }
    }
}
