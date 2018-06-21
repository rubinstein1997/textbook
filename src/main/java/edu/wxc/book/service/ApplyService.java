package edu.wxc.book.service;

import edu.wxc.book.domain.ApplyItem;
import edu.wxc.book.domain.User;
import edu.wxc.book.mapper.ApplyMapper;
import edu.wxc.book.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ApplyService {
    private ApplyMapper applyMapper;
    private ItemMapper itemMapper;

    @Autowired
    public ApplyService(ApplyMapper applyMapper, ItemMapper itemMapper) {
        this.applyMapper = applyMapper;
        this.itemMapper = itemMapper;
    }


    public void  bookApply(List<ApplyItem> applyItems, HttpSession httpSession) {
        User user  = (User) httpSession.getAttribute("user");
        Integer userId = Integer.valueOf(user.getUser_id());
        int apply_id =  applyMapper.addApply(userId,22);
        for(ApplyItem applyItem : applyItems) {
            itemMapper.addItem(apply_id,applyItem);
        }
    }


}
