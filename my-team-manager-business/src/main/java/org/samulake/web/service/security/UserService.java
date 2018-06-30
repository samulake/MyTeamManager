package org.samulake.web.service.security;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.persistence.dao.UserDao;
import org.samulake.web.service.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService, Model<UserDto> {
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

    @Override
    public UserDto getLoggedUserDetails() {
        return loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @Override
    public boolean authenticated(UserDetails userDetails) {
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

    public boolean isLoggedIn() {
        return SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    }

    @Override
    public UserDto getData() {
        return getLoggedUserDetails();
    }

    @Override
    public void updateData(UserDto data) {

    }
}
