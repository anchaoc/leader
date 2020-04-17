package com.ac.hutool;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author anchao
 * @date 2020/4/16 16:38
 **/
@Slf4j
public class ExcelTest {
    /**
     * sax方法读取
     * 行行读取
     */
    @Test
    public void excelTest(){
        File file = new File("C:\\Users\\anchao\\Desktop\\中税任务备份\\审计分录任务\\8万行序时账.xlsx");
        ExcelUtil.readBySax(file,-1,(sheetIndex, rowIndex, rowList)->{
            log.info("--> rowList:{}",rowList);
        });
    }





    /**
     * 普通读取
     * 一次性把数据加载到内存
     */
    @Test
    public void excelTest2() throws IOException {
        InputStream file = new FileInputStream("C:\\Users\\anchao\\Desktop\\中税任务备份\\表公式录入\\2020-4-10公式修订后版-工作底稿与申报表及调整汇总等全部链接V9.xlsx");
        ExcelReader reader = ExcelUtil.getReader(file,true);
        List<Sheet> sheets = reader.getSheets();
//        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
//        for (int i = 1; i <=physicalNumberOfRows ; i++) {
//            Row row = sheet.getRow(i);
//            Cell cell = row.getCell(1);
//            log.info("---->cell:{}",cell);
//        }
    }
}
