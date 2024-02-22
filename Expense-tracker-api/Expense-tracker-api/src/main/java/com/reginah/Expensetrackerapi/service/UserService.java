package com.reginah.Expensetrackerapi.service;

import com.reginah.Expensetrackerapi.entity.User;
import com.reginah.Expensetrackerapi.entity.UserModel;

public interface UserService {

    User createUser(UserModel user);
    User readUser(Long id);

}
