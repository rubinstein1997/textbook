package edu.wxc.book.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * \* User: root
 * \* @author: liuyunlong
 * \* Date: 2018/7/4
 * \* Time: 1:01
 * \
 */
@Controller
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String main(HttpServletRequest request) {
        if(request.isUserInRole("ROLE_secretary")) {
            logger.info("角色: secretary");
            return "forward:/secretary/main";
        }
        else {
            logger.info("角色: auditor");
            return "forward:/auditor/main";
        }
    }
}