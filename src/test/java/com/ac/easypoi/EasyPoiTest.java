package com.ac.easypoi;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.Map;

/** 简易的poi
 * @author anchao
 * @date 2020/4/17 16:48
 **/
public class EasyPoiTest {

    @Test
    public void easyTest(){
        File file = new File("C:\\Users\\anchao\\Desktop\\中税任务备份\\审计分录任务\\8万行序时账.xlsx");
        ImportParams importParams = new ImportParams();
        List<Map> objects = ExcelImportUtil.importExcel(file, Map.class, importParams);
        System.out.println(objects.size());
    }
}
