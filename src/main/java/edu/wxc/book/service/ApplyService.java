package edu.wxc.book.service;

import edu.wxc.book.domain.ApplyItem;
import edu.wxc.book.domain.User;
import edu.wxc.book.mapper.ApplyMapper;
import edu.wxc.book.mapper.ItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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


    public void  bookApply(List<ApplyItem> applyItems, HttpSession httpSession) {
        User user  = (User) httpSession.getAttribute("user");
        int userId = user.getUserId();
        int apply_id =  applyMapper.addApply(userId,22);
        for(ApplyItem applyItem : applyItems) {
            itemMapper.addItem(apply_id,applyItem);
        }
    }


}
