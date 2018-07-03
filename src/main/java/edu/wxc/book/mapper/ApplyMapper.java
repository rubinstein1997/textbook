package edu.wxc.book.mapper;

import edu.wxc.book.domain.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component
public interface ApplyMapper {
//    Integer addApply(@Param("user_id") int user_id, @Param("status") int status, @Param("timestamp") Timestamp timestamp);


    /**
     * add apply
     * @param apply
     * @return Integer
     */
    Integer addApply(Apply apply);


    /**
     * fetch data by UserId
     * @param userId
     * @return List<Apply>
     */
    List<Apply> selectByUserId(Integer userId);
}
