package edu.wxc.book.service;

import edu.wxc.book.domain.Item;
import edu.wxc.book.domain.User;
import edu.wxc.book.mapper.ApplyMapper;
import edu.wxc.book.mapper.ItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


@Service
public class ApplyService {
    private Logger logger = LoggerFactory.getLogger(ApplyService.class);

    private ApplyMapper applyMapper;
    private ItemMapper itemMapper;

    @Autowired
    public ApplyService(ApplyMapper applyMapper, ItemMapper itemMapper) {
        this.applyMapper = applyMapper;
        this.itemMapper = itemMapper;
    }


    public void  bookApply(List<Item> items, HttpSession httpSession) {
        //正式需要取消注释
        User user  = (User) httpSession.getAttribute("user");
        int userId = user.getUserId();
        int apply_id =  applyMapper.addApply(user.getUserId(),22,new Timestamp(new Date().getTime()));
        for(Item item: items) {
            itemMapper.addItem(apply_id, item);
        }
    }


}
