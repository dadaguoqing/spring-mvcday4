package com.interception;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class: LoginInterception
 * Description: TODO
 * Author: Genius
 * Date: 2019/3/18 11:26
 * Version: V1.0
 */
public class LoginInterception extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginSuccess = request.getSession().getAttribute("loginSuccess");
        if (loginSuccess == null) {
            response.sendRedirect(request.getContextPath() + "/login.do?msg=您尚未登录");
            return false;
        }
        return true;
    }
}
