package edu.wxc.book.security;

import edu.wxc.book.domain.User;
import edu.wxc.book.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * \* User: root
 * \* @author: liuyunlong
 * \* Date: 2018/7/4
 * \* Time: 0:46
 * \
 */
@Component
public class MyUserDetailService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userId) {
        User user = userService.selectById(userId);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        logger.info("认证：{}",authorities);
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.getUserId()),passwordEncoder.encode(user.getPasswd()),authorities);

    }

}