package edu.wxc.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \* User: root
 * \* @author: liuyunlong
 * \* Date: 2018/7/4
 * \* Time: 1:01
 * \
 */
@Controller
public class UserController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}