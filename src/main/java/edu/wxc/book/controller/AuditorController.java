package edu.wxc.book.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.wxc.book.domain.Item;
import edu.wxc.book.domain.JsonData;
import edu.wxc.book.domain.User;
import edu.wxc.book.service.ExcelService;
import edu.wxc.book.service.SecretaryApplyService;
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
 * \* User: root
 * \* Date: 2018/7/3
 * \* Time: 15:00
 * \
 */

@Controller
@RequestMapping("/auditor")
public class AuditorController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/me")
    public String test() {
        return "/auditor/me";
    }
}