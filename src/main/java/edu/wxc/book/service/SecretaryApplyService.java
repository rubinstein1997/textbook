package edu.wxc.book.service;

import edu.wxc.book.domain.Apply;
import edu.wxc.book.domain.Item;
import edu.wxc.book.mapper.ApplyMapper;
import edu.wxc.book.mapper.ItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class SecretaryApplyService {
    private Logger logger = LoggerFactory.getLogger(SecretaryApplyService.class);

    private ApplyMapper applyMapper;
    private ItemMapper itemMapper;

    @Autowired
    public SecretaryApplyService(ApplyMapper applyMapper, ItemMapper itemMapper) {
        this.applyMapper = applyMapper;
        this.itemMapper = itemMapper;
    }


    //wait for complete
    public void  bookApply(List<Item> items, HttpSession httpSession) {
        //正式需要取消注释
//        User user  = (User) httpSession.getAttribute("user");
//        int userId = user.getUserId();
//        int apply_id =  applyMapper.addApply(user.getUserId(),22,new Timestamp(new Date().getTime()));
//        for(Item item: items) {
//            itemMapper.addItem(apply_id, item);
//        }
    }

    public List<Apply> applyStatus(Integer userId) {
        return applyMapper.selectByUserId(userId);
    }

    public List<Item> getItemsByApplyId(Integer applyId) {
        return itemMapper.selectByApplyId(applyId);
    }




}
