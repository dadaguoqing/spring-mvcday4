package com.controller;

import com.commons.Result;
import com.commons.ResultState;
import com.domain.User;
import com.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Class: LoginController
 * Description: TODO
 * Author: Genius
 * Date: 2019/3/17 21:44
 * Version: V1.0
 */
@Controller
public class LoginController {
    @Autowired
    @Qualifier("loginService")
    private ILoginService loginService;

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("check")
    public String check(User user, HttpSession session, Model model) {
        Result<User> result = loginService.checkLogin(user);
        System.out.println(user);
        if (result.getState() == null ? ResultState.SUCCESS.getState() == null : result.getState().equals(ResultState.SUCCESS.getState())) {
            session.setAttribute("loginSuccess", result.getData());
            return "redirect:/index.do";
        } else {
            model.addAttribute("msg", result.getMsg());
        }
        return "login";
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
