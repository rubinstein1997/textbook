package edu.wxc.book.mapper;

import edu.wxc.book.domain.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Component
public interface ApplyMapper {
//    Integer addApply(@Param("user_id") int user_id, @Param("status") int status, @Param("timestamp") Timestamp timestamp);

    Integer addApply(Apply apply);

    List<Apply> selectByUserId(Integer userId);
}
