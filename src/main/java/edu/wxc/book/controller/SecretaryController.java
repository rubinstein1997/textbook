package edu.wxc.book.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.wxc.book.domain.Apply;
import edu.wxc.book.domain.Item;
import edu.wxc.book.domain.JsonData;
import edu.wxc.book.domain.User;
import edu.wxc.book.service.SecretaryApplyService;
import edu.wxc.book.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author:liuyunlong
 */
@Controller
@RequestMapping("/secretary")
public class SecretaryController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecretaryApplyService applyService;

    @Autowired
    private ExcelService excelService;

    @Autowired
    private StringRedisTemplate redisTpl;

    @RequestMapping("main")
    public String main() {
        return "/secretary/main";
    }

    @RequestMapping(value = "manualApply", method = RequestMethod.GET)
    public String manualApply() {
        return "/secretary/manualApply";
    }

    @RequestMapping(value = "excelApply", method = RequestMethod.GET)
    public String excelApply() {
        return "/secretary/excelApply";
    }

    @ResponseBody
    @RequestMapping(value = "manualApplyPost")
    public ResponseEntity manualApplyPost(@RequestBody List<Item> items, HttpSession httpSession) {
        applyService.bookApply(items, httpSession);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "excelApplyPost")
    public String excelApplyPost(@RequestParam("file") MultipartFile file, HttpSession httpSession)
            throws IOException {

        User user = (User) httpSession.getAttribute("user");
        excelService.handleExcelApply(file,user);
        return "/secretary/excelApply";
    }

    @GetMapping("applyStatus")
    public String applyStatus(@RequestParam(value = "page",defaultValue = "1") int page,
                              @RequestParam(value = "size" ,defaultValue = "10") int size,
                              ModelMap modelMap, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        logger.info("session: {}",user);
        PageHelper.startPage(page,size);
        modelMap.addAttribute("user",user);
        modelMap.addAttribute("applies",new PageInfo<>(applyService.applyStatus(user.getUserId())));
        return "/secretary/applyStatus";
    }

    @ResponseBody
    @GetMapping("applyItems/{id}")
    public JsonData applyItems(@PathVariable("id") Integer id, HttpSession httpSession) {
        return  new JsonData(0,applyService.getItemsByApplyId(id),"ok");

    }


//    @ResponseBody
//    @GetMapping("test")
//    public void test() {
//
//        redisTpl.ops
//    }

}
