package edu.wxc.book.service;

import edu.wxc.book.domain.Role;
import edu.wxc.book.domain.User;
import edu.wxc.book.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }



//    public User selectById(String id) {
//        return UserMapper.selectById(id);
//    }
//
//    public User login(String id, String passwd) {
//        return UserMapper.selectByIdAndPasswd(id, passwd);
//    }


    @Override
    public UserDetails loadUserByUsername(String userId) {

        User user = userMapper.selectById(String.valueOf(userId));
        logger.info("user {}",user);
        if(user == null) {
            throw new UsernameNotFoundException("用户id不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

//        for(Role role: user.getRoles()) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }

        authorities.add(new SimpleGrantedAuthority("ROLE_secretary"));
//        logger.info("yi jinxing dao zheyibu ");
        return new org.springframework.security.core.userdetails.User(user.getUserId(),passwordEncoder.encode(user.getPasswd()),authorities);
    }
}
