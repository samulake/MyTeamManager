package org.samulake.web.service.security;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.persistence.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RegistrationUserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void save(String name, String username, String password) {
        UserDto user = new UserDto();
        user.setFirstName(name);
        user.setUser(true);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userDao.save(user);
    }

//    @PostConstruct
//    public void registerTestUser() {
//        save("test","test", "test");
//    }
}
