package edu.wxc.book.service;

import edu.wxc.book.domain.User;
import edu.wxc.book.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserMapper UserMapper;

    @Autowired
    public UserService(UserMapper UserMapper) {
        this.UserMapper = UserMapper;
    }

    public User selectById(String id) {
        return UserMapper.selectById(id);
    }

    public User login(Integer id, String passwd) {
        return UserMapper.selectByIdAndPasswd(id, passwd);
    }

}
