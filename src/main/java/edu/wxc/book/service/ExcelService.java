package edu.wxc.book.service;

import edu.wxc.book.domain.User;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

@Service
public class ExcelService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void handleExcelApply(MultipartFile file, User user) throws IOException {
        DataFormatter fomat = new DataFormatter();
        if (!file.isEmpty()) {
            logger.info(file.getOriginalFilename());
            InputStream is = file.getInputStream();
            HSSFWorkbook wb = new HSSFWorkbook(is);
            HSSFSheet sheet = wb.getSheet("Sheet1");
            for (int i = 3; i < sheet.getLastRowNum(); i++) {
                //excel行
                HSSFRow row = sheet.getRow(i);
                Iterator cells = row.cellIterator();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    logger.info("第{}行   值{}",i,fomat.formatCellValue(cell));
                }
            }
        }
    }
}
