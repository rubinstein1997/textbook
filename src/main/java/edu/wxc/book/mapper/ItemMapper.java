package edu.wxc.book.mapper;

import edu.wxc.book.domain.ApplyItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ItemMapper {
    Integer addItem(@Param("applyId") int applyId, @Param("applyItem") ApplyItem applyItem);

}
