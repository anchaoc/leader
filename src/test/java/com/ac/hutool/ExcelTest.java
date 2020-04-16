package com.ac.hutool;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;

import java.io.File;

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
        ExcelUtil.readBySax(file,0,(sheetIndex, rowIndex, rowList)->{
            log.info("--> rowList:{}",rowList);
        });
    }






    /**
     * 普通读取
     * 一次性把数据加载到内存
     */
    @Test
    public void excelTest2(){
        File file = new File("C:\\Users\\anchao\\Desktop\\中税任务备份\\审计分录任务\\8万行序时账.xlsx");
        ExcelReader reader = ExcelUtil.getReader(file);
        reader.setSheet(0);
        Sheet sheet = reader.getSheet();
        int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
//        for (int i = 1; i <=physicalNumberOfRows ; i++) {
//            Row row = sheet.getRow(i);
//            Cell cell = row.getCell(1);
//            CellType cellType = cell.getCellType();
//            log.info("---->cell:{}",cell);
//        }
    }
}
