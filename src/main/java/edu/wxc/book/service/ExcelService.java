package edu.wxc.book.service;

import edu.wxc.book.domain.Apply;
import edu.wxc.book.domain.Item;
import edu.wxc.book.domain.User;
import edu.wxc.book.mapper.ApplyMapper;
import edu.wxc.book.mapper.ItemMapper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;

@Service
public class ExcelService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ApplyMapper applyMapper;
    private ItemMapper itemMapper;

    @Autowired
    public ExcelService(ApplyMapper applyMapper, ItemMapper itemMapper) {
        this.applyMapper = applyMapper;
        this.itemMapper = itemMapper;
    }


    public void handleExcelApply(MultipartFile file, User user) throws IOException {

        //插入apply表，获取apply_id
        //status表示等待中
        Apply apply = new Apply(null,user.getUserId(),0,null,new Timestamp(new Date().getTime()));
        applyMapper.addApply(apply);

        DataFormatter fomat = new DataFormatter();
        if (!file.isEmpty()) {
            logger.info(file.getOriginalFilename());
            InputStream is = file.getInputStream();
            HSSFWorkbook wb = new HSSFWorkbook(is);
            HSSFSheet sheet = wb.getSheet("Sheet1");

            boolean flag = false;

            Item item = new Item();

            //此为excel到表尾跳转到的地方
            endParse:
            //start at third row
            if(!flag) {
                for (int i = 3; i < sheet.getLastRowNum(); i++) {
                    //excel行
                    HSSFRow row = sheet.getRow(i);
                    Iterator cells = row.cellIterator();
                    while (cells.hasNext()) {
                        HSSFCell cell = (HSSFCell) cells.next();

                        String value = fomat.formatCellValue(cell);

                        switch (cell.getColumnIndex()) {
                            case 0:
                                if (value.isEmpty()) {
                                    flag = true;
                                    break endParse;
                                }
                                item.setCourseTitle(value);
                                break;
                            case 1:
                                item.setIsbn(value);
                                break;
                            case 2:
                                item.setBookName(value);
                                break;
                            case 3:
                                item.setAuthor(value);
                                break;
                            case 4:
                                item.setPress(value);
                                break;
                            case 5:
                                item.setPublishTime(value);
                                break;
                            case 6:
                                item.setBookCategory(value);
                                break;
                            case 7:
                                item.setMajorGrade(value);
                                break;
                            case 8:
                                item.setStudentNumber(value);
                                break;
                            case 9:
                                item.setTeacherBook(value);
                                break;
                            case 10:
                                item.setTotalNumber(value);
                                break;
                            case 11:
                                item.setRemark(value);
                                break;
                        }
                    }
                    itemMapper.addItem(apply.getApplyId(), item);
                }
            }
        }
    }
}
