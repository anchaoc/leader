package com.ac.excel;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        MeData meData1 = new MeData(0, "A", "1");
        MeData meData2 = new MeData(1, "A", "2");
        List<MeData> meDataList = Arrays.asList(meData1,meData2);
        meDataList= new ArrayList<>(meDataList);


        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet();
        for (MeData meData : meDataList) {
            int row_index = meData.getRow();
            String col = meData.getCol();
            String value = meData.getValue();
            if (sheet.getRow(row_index)!=null) {
                Row row = sheet.getRow(row_index);
                int col_index = CellReference.convertColStringToIndex(col);
                row.createCell(col_index).setCellValue(Double.valueOf(value));
            }
            else{
                Row row = sheet.createRow(row_index);
                int col_index = CellReference.convertColStringToIndex(col);
                row.createCell(col_index).setCellValue(Double.valueOf(value));
            }
        }
        int rowNumNew = sheet.getLastRowNum()+1;
        Row row = sheet.createRow(rowNumNew);
        Cell cell = row.createCell(0);
        FormulaEvaluator evaluator = sheet.getWorkbook().getCreationHelper().createFormulaEvaluator();
        cell.setCellFormula("IF(A1<A2,10,20)");
        evaluator.evaluateFormulaCell(cell);
        CellValue cellValue = evaluator.evaluate(cell);
        double data = cellValue.getNumberValue();
        System.out.println("--> data: " + data);
    }

    @Data
    @AllArgsConstructor
    public class MeData{
        private int row;
        private String col;
        private String value;
    }
}
