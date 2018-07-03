package edu.wxc.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/4033")
    public String whr() {
        return "403";
    }

    @RequestMapping("/4053")
    public String kk() {
        return "403";
    }
}

