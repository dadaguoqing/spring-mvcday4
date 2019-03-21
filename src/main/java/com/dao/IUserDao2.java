package com.dao;

import com.domain.User;

import java.util.List;

public interface IUserDao2 {
    int insertByUser(User user);

    void deleteByUser(User user);

    int updateByUser(User user);

    List<User> selectAllUser();

    User selectUser(User user);
}
