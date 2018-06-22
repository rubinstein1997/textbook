package edu.wxc.book.mapper;

import edu.wxc.book.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
    User selectById(Integer id);

    User selectByIdAndPasswd(
            @Param("id") Integer id,
            @Param("passwd") String passwd);
}
