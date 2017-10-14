package pk.com.habsoft.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pk.com.habsoft.model.Person;
import pk.com.habsoft.security.JwtTokenUtil;
import pk.com.habsoft.security.JwtUser;

@RestController
public class PersonController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    private static List<Person> allPersons = new ArrayList<>();
    static {
        allPersons.add(new Person("Alpha", "Bravo"));
        allPersons.add(new Person("Beta", "Harry"));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }

    @RequestMapping(value = "/list/")
    public List<Person> getAllPersons() {
        return allPersons;
    }

}
