package edu.wxc.book.controller;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;
import edu.wxc.book.domain.ApplyItem;
import edu.wxc.book.domain.User;
import edu.wxc.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginForm(
            @RequestParam("id") String id,
            @RequestParam("passwd") String passwd,
            @RequestParam("role") String role,
            HttpSession httpSession,
            Model model) {

        User user = null;

        switch (role) {

            case "0":
                user = userService.login(id,passwd);
                user.setRole("secretary");
                break;
            case "2":
                user = userService.login(id,passwd);
                user.setRole("auditor");
                break;

        }

        if(user != null) {
            httpSession.setAttribute("user",user);
            return "redirect:/" + user.getRole() + "/applypage";
        } else {
            model.addAttribute("message", "登录名或密码输入错误");
            return "forward:/login";
        }

    }

}
