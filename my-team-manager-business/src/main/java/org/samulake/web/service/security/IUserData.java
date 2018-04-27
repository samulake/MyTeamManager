package org.samulake.web.service.security;

import org.samulake.web.core.dto.UserDto;

public interface IUserData {
    UserDto getUserDetails(String userName);
}
