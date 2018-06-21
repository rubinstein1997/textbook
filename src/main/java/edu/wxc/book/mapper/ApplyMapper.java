package edu.wxc.book.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ApplyMapper {
    Integer addApply(@Param("user_id") int user_id,@Param("status") int status);
}
