package org.samulake.web.service.security;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.persistence.dao.UserDao;
import org.samulake.web.service.Model;
import org.samulake.web.service.impl.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserService extends AbstractService<UserDto, UserDao> implements IUserService, Model<UserDto> {

    @Autowired
    private RegistrationUserService registrationUserService;
    @Autowired
    private DaoAuthenticationProvider authenticationProvider;

    @Autowired
    public UserService(UserDao userDao) {
        super(userDao);
    }

    @PostConstruct
    private void addTestUser() {
        registrationUserService.save("test", "test", "test");
    }

    @Override
    public UserDto loadUserByUsername(String username) throws UsernameNotFoundException {
        return getDao().getByName(username);
    }

    @Override
    public UserDto getLoggedUserDetails() {
        return loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public boolean authenticated(UserDetails userDetails) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());

        try {
            if(authentication == null) {
                return false;
            }
            Authentication authenticated = authenticationProvider.authenticate(authentication);
            if (authenticated.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authenticated);
                return true;
            }
        } catch (AuthenticationException e) {
            return false;
        }
        return false;
    }

    public boolean isLoggedIn() {
        return SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }
}
