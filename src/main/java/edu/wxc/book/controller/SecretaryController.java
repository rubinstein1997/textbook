package edu.wxc.book.controller;

import edu.wxc.book.domain.ApplyItem;
import edu.wxc.book.domain.User;
import edu.wxc.book.mapper.ApplyMapper;
import edu.wxc.book.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/secretary")
public class SecretaryController {

    @Autowired
    ApplyService applyService;

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
    public ResponseEntity manualApplyPost(@RequestBody List<ApplyItem> applyItems, HttpSession httpSession) {
        applyService.bookApply(applyItems, httpSession);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "excelApplyPost")
    public void excelApplyPost() {

    }

}
