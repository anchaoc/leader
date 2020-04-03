package com.ac.leader.importexcel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author anchao
 * @date 2020/4/3 15:40
 */
@Slf4j
public class ExcelOpeTest {

    @Test
    public void excelTest(){
        final int rowNum =4;
        final int cellNum=4;
        try {
            Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\anchao\\Desktop\\资产负债表.xlsx"));
            Sheet sheet = workbook.getSheetAt(0);
            int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
            System.out.println("---->总行数："+physicalNumberOfRows);

            Kmyeb name1 = new Kmyeb("货币资金", 10.1111, 10.1111);
            Kmyeb name2 = new Kmyeb("△结算备付金", 10.1111, 10.1111);
            Kmyeb name3 = new Kmyeb("开发支出", 1.00, 1.00);
            List<Kmyeb> kmyebList = Arrays.asList(name1, name2, name3);
            for (int i = rowNum; i <physicalNumberOfRows ; i++) {
                Row row = sheet.getRow(i);
                if (ObjectUtils.isEmpty(row) || checkRowCellIsAllNull(row)) {
                    continue;
                }
                double price1=0.0,price2=0.0;
                Object value0 = this.getCellFormulaValue(row.getCell(0));
                Optional<Kmyeb> kmyeb = kmyebList.stream().filter(k -> value0.equals(k.getName().trim())).findFirst();
                if(kmyeb.isPresent()){
                    price1 =kmyeb.get().getPrice1();
                    price2 =kmyeb.get().getPrice2();
                }
                Cell cell1 = row.getCell(1);
                Cell cell2 = row.getCell(2);
                cell1.setCellValue(price1);
                cell2.setCellValue(price2);
                Object value1 = this.getCellFormulaValue(row.getCell(1));
                Object value2 = this.getCellFormulaValue(row.getCell(2));
                Object value3 = this.getCellFormulaValue(row.getCell(3));
                System.out.print(ObjectUtils.isEmpty(value0)? StringUtils.EMPTY:value0);
                System.out.print("-->");
                System.out.print(value1);
                System.out.print("-->");
                System.out.print(value2);
                System.out.print("-->");
                System.out.print(ObjectUtils.isEmpty(value3)?"是":value3);
                System.out.print("-->");
                System.out.println(" ");
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("异常---->",e);
        }
    }


    /**
     * 校验当前行中全是否空列
     */
    private boolean checkRowCellIsAllNull(Row row) {
        for (Cell cell : row) {
            if (!ObjectUtils.isEmpty(this.getCellFormulaValue(cell))) {
                return false;
            }
        }
        return true;
    }


    /**
     * 解析excel单元格中的每一行每一列
     * 遇到公式则按照公式计算
     */
    private  Object getCellFormulaValue(Cell cell) {
        if (cell == null) {
            return StringUtils.EMPTY;
        }
        Object obj = null;
        switch (cell.getCellType()) {
            case BOOLEAN:
                obj = cell.getBooleanCellValue();
                break;
            case ERROR:
                obj = cell.getErrorCellValue();
                break;
            case FORMULA:
                try {
                    cell.setCellFormula(cell.getCellFormula().trim().replace(",,", ","));
                    FormulaEvaluator evaluator = cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
                    evaluator.evaluateFormulaCell(cell);
                    CellValue cellValue = evaluator.evaluate(cell);
                    Double celldata = cellValue.getNumberValue();
                    System.out.println("-->cellFormula value: " + celldata);
                    obj = celldata;
                } catch (IllegalStateException e) {
                    obj = cell.getNumericCellValue();
                } catch (Exception e) {
                    obj = cell.getCellFormula();
                }
                break;
            case NUMERIC:
                short format = cell.getCellStyle().getDataFormat();
                if (DateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = null;
                    if (format == 20 || format == 32) {
                        sdf = new SimpleDateFormat("HH:mm");
                    } else if (format == 14 || format == 31 || format == 57 || format == 58) {
                        // 处理自定义日期格式：m月d日(通过判断单元格的格式id解决，id的值是58)
                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                        double value = cell.getNumericCellValue();
                        Date date = DateUtil
                                .getJavaDate(value);
                        obj = sdf.format(date);
                    } else {// 日期
                        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    }
                    try {
                        obj = sdf.format(cell.getDateCellValue());// 日期
                    } catch (Exception e) {
                        try {
                            throw new Exception("exception on get date data !".concat(e.toString()));
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                } else {
                    Long longVal = Math.round(cell.getNumericCellValue());
                    double doubleVal = cell.getNumericCellValue();
                    if (Double.parseDouble(longVal + ".0") == doubleVal) {
                        obj = longVal;
                    } else {
                        obj = BigDecimal.valueOf(cell.getNumericCellValue());
                    }
                }

                break;
            case STRING:
                String value = String.valueOf(cell.getStringCellValue());
                value = value.replace(" ", "");
                value = value.replace("\n", "");
                value = value.replace("\t", "");
                value = value.trim();
                obj = value;
                break;
            default:
                obj = StringUtils.EMPTY;
                break;
        }
        return obj;
    }


    @AllArgsConstructor
    @Data
    class Kmyeb{
        private String name;
        private double price1;
        private double price2;
    }
}
