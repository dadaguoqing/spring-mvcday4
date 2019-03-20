package com.dao.impl;

import com.dao.IUserDao;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: UserDaoImpl
 * Description: TODO
 * Author: Genius
 * Date: 2019/3/18 11:56
 * Version: V1.0
 */
@Repository("userDao")
public class UserDaoImpl implements IUserDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<User> selectByUser(User user) {
        String sql = "select name,pwd from user where name=? and pwd=?";
        List<User> query = jdbcTemplate.query(sql, new Object[]{user.getName(), user.getPwd()}, new BeanPropertyRowMapper<User>(User.class));
        if (query.isEmpty()) {
            return null;
        }
        return query;
    }
}
