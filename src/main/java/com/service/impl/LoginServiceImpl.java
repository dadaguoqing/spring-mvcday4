package com.service.impl;

import com.commons.Result;
import com.commons.ResultState;
import com.dao.IUserDao;
import com.domain.User;
import com.service.ILoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class: LoginServiceImpl
 * Description: TODO
 * Author: Genius
 * Date: 2019/3/18 11:53
 * Version: V1.0
 */
@Service("loginService")
public class LoginServiceImpl implements ILoginService {
    //    日志记录器
    private Logger logger = LogManager.getLogger(LoginServiceImpl.class.getName());

    @Autowired
    @Qualifier("userDao")
    private IUserDao userDao;

    @Autowired
    @Qualifier("result")
    private Result<User> result;

    public Result<User> checkLogin(User user) {
        List<User> users = userDao.selectByUser(user);
        logger.debug(users + "==========" + user);
        if (users == null) {
            result.setResultState(ResultState.INPUT_NAME_OR_PASSWORD);
        } else {
            result.setData(users.get(0));
        }
        return result;
    }
}
