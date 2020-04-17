package com.ac.excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.IOException;

/**
 * @author anchao
 * @date 2020/4/17 13:58
 **/
public class FormulaTest {

    /**
     * 公式计算测试
     */
    @Test
    public void test() throws IOException {
        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet("test");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue(1);
        row.createCell(1).setCellValue(2);
        row.createCell(2).setCellValue(3);
        row.createCell(3).setCellValue(4);
        row.createCell(4).setCellValue(5);
        Cell cell = sheet.getRow(0).createCell(5);
       // String colString = CellReference.convertNumToColString(0);  //长度转成ABC列
        cell.setCellFormula("=sum(a1:e1)".replaceAll("=",""));
        //sheet.setForceFormulaRecalculation(true);//强制执行新设置的公式
        //按公式计算
        FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
        evaluator.evaluateFormulaCell(cell);
        CellValue cellValue = evaluator.evaluate(cell);
        double celldata = cellValue.getNumberValue();
        System.out.println("--> value: " + celldata);
    }
}
