package org.samulake.web.service.security;

import org.samulake.web.core.dto.UserDto;
import org.samulake.web.service.Model;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService, Model<UserDto> {
    UserDto getLoggedUserDetails();

    boolean authenticated(UserDetails userDetails);
}
