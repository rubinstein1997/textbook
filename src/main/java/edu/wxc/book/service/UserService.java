package edu.wxc.book.service;

import edu.wxc.book.domain.Role;
import edu.wxc.book.domain.User;
import edu.wxc.book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private UserMapper userMapper;

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


    public UserDetails loadUserByUsername(String userId) {
        User user = userMapper.selectById(String.valueOf(userId));
        if(user == null) {
            throw new UsernameNotFoundException("用户id不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for(Role role: user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUserId(),user.getPasswd(),authorities);
    }
}
