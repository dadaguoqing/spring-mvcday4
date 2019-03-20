package com.service;

import com.commons.Result;
import com.domain.User;

public interface ILoginService {
    Result<User> checkLogin(User user);
}
