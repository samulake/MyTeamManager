package org.samulake.web.service.security;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.persistence.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("userDetailsService")
public class UserService implements UserDetailsService, IUserData {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RegistrationUserService registrationUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getByName(username);
    }

    @Override
    public UserDto getUserDetails(String login) {
        return userDao.getByName(login);
    }
}
