package edu.wxc.book.mapper;

import edu.wxc.book.domain.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ItemMapper {
    Integer addItem(@Param("applyId") int applyId, @Param("item") Item item);

    List<Item> selectByApplyId(Integer applyId);
}
