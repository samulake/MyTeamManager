package org.samulake.web.service.security;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.persistence.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RegistrationUserService registrationUserService;
    @Autowired
    private DaoAuthenticationProvider authenticationProvider;

    @Override
    public UserDto loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getByName(username);
    }

    public UserDto getLoggedUserDetails() {
        return loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public boolean authenticate(UserDetails userDetails) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
        try {
            Authentication authenticated = authenticationProvider.authenticate(authentication);
            if (authenticated.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authenticated);
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }
}
