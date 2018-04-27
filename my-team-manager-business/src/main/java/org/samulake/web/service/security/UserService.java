package org.samulake.web.service.security;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.persistence.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserData {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDto getUserDetails(String userName) {
        return userDao.getByName(userName);
    }
}
