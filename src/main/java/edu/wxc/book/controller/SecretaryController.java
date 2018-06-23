package edu.wxc.book.controller;

import edu.wxc.book.domain.ApplyItem;
import edu.wxc.book.domain.User;
import edu.wxc.book.service.ApplyService;
import edu.wxc.book.service.ExcelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/secretary")
public class SecretaryController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ApplyService applyService;

    @Autowired
    ExcelService excelService;

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
    public String excelApplyPost(@RequestParam("file") MultipartFile file, HttpSession httpSession)
            throws IOException {
        User user = new User(2);
        excelService.handleExcelApply(file,user);
        return "/secretary/excelApply";
    }

}
