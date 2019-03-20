package com.dao;

import com.domain.User;

import java.util.List;

/**
 * Class: IUserDao
 * Description: TODO
 * Author: Genius
 * Date: 2019/3/17 21:55
 * Version: V1.0
 */

public interface IUserDao {
    List<User> selectByUser(User user);
}
