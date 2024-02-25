package com.reginah.Expensetrackerapi.service;

import com.reginah.Expensetrackerapi.entity.User;
import com.reginah.Expensetrackerapi.dto.UserDto;

public interface UserService {

    UserDto createUser(UserDto user);
    User readUser(Long id);

    User updateUser(UserDto user, Long id);

    void deleteUser(Long id);

    User findUserByEmail(String email);

    UserDto getAuthenticatedUser(String basicAuthString);
}
