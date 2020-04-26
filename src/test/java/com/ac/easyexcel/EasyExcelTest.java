package com.ac.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.holder.ReadRowHolder;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellReference;
import org.junit.Test;

import java.io.File;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/** alibaba easy excel
 * @author anchao
 * @date 2020/4/13 16:31
 **/
@Slf4j
public class EasyExcelTest {
    /**
     * 测试写入
     */
    @Test
    public void importExcelTest(){
        File file = new File("C:\\Users\\anchao\\Desktop\\test.xlsx");
        ImportTest importTest = new ImportTest();
        importTest.setName("测试");
        List<ImportTest> importTestList = Collections.singletonList(importTest);
        // 头的策略
        WriteCellStyle headWriteCellStyle = new WriteCellStyle();
        // 背景色
        headWriteCellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        WriteFont headWriteFont = new WriteFont();
        headWriteFont.setFontHeightInPoints((short) 12);
        headWriteCellStyle.setWriteFont(headWriteFont);
        // 内容的策略
        WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
        // 这里需要指定 FillPatternType 为FillPatternType.SOLID_FOREGROUND 不然无法显示背景颜色.头默认了 FillPatternType所以可以不指定
        // contentWriteCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
        // 背景绿色
        //contentWriteCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        //边框
        //contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
        //contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
        // 字体策略
        WriteFont contentWriteFont = new WriteFont();
        // 字体大小
        contentWriteFont.setFontHeightInPoints(Short.valueOf("12"));
        contentWriteCellStyle.setWriteFont(contentWriteFont);
        //设置 自动换行
        contentWriteCellStyle.setWrapped(true);
        //设置 垂直居中
        contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(headWriteCellStyle, contentWriteCellStyle);
        //写
        EasyExcel.write(file)
                .sheet("审计分录")
                .head(ImportTest.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .table(1)
                .doWrite(importTestList);

    }

    /**
     * 标准逐条读取读取测试
     */
    @Test
    public void excelTest1() {
        File file = new File("C:\\Users\\anchao\\Desktop\\中税任务备份\\审计分录任务\\8万行序时账.xlsx");
        MyExcelListener myExcelListener = new MyExcelListener();
        EasyExcel.read(file, ReadData.class, myExcelListener)
                .sheet(0)
                .headRowNumber(5)
                .doRead();
    }




    /**
     * 特殊逐条读取读取测试
     */
    @Test
    public void excelTest2(){
        File file = new File("C:\\Users\\anchao\\Desktop\\12.xlsx");
        ExcelListener myExcelListener = new ExcelListener();
        ExcelReader excelReader = EasyExcel.read(file, myExcelListener)
                .doReadAll();
        int size = excelReader.excelExecutor().sheetList().size();
        log.info("总导入sheet页数 size：{}",size-1);
    }

    public class ExcelListener extends AnalysisEventListener<LinkedHashMap<Integer,String>>{
        @Override
        public void invoke(LinkedHashMap<Integer,String> data, AnalysisContext context) {
            data.forEach((k,v)->{
                String col_name = CellReference.convertNumToColString(k);
                if (StringUtils.isNotEmpty(v)) {
                    log.info("当前sheet页解析中 col_name:{} value：{}",col_name,v);
                }else{
                    log.info("当前sheet页解析中 col_name:{} value：{}",col_name,v);
                }
            });
            ReadSheetHolder readSheetHolder = context.readSheetHolder();
            ReadRowHolder readRowHolder = context.readRowHolder();
            Integer rowIndex = readRowHolder.getRowIndex();
            String sheetName = readSheetHolder.getSheetName();
            Integer sheetNo = readSheetHolder.getSheetNo();
            log.info("当前sheet页解析中  sheetName：{},sheetNo:{},rowIndex：{}",sheetName,sheetNo,rowIndex);
            System.out.println(data);
        }
        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            ReadSheetHolder readSheetHolder = context.readSheetHolder();
            ReadRowHolder readRowHolder = context.readRowHolder();
            Integer rowIndex = readRowHolder.getRowIndex();
            String sheetName = readSheetHolder.getSheetName();
            Integer sheetNo = readSheetHolder.getSheetNo();
            log.info("当前sheet页解析完成  sheetName：{},sheetNo:{},rowIndex：{}",sheetName,sheetNo,rowIndex);
        }

        @Override
        public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
            ReadSheetHolder readSheetHolder = context.readSheetHolder();
            ReadRowHolder readRowHolder = context.readRowHolder();
            Integer rowIndex = readRowHolder.getRowIndex();
            String sheetName = readSheetHolder.getSheetName();
            Integer sheetNo = readSheetHolder.getSheetNo();
            log.info("当前sheet页解析表头部分 sheetName：{},sheetNo:{},rowIndex：{}",sheetName,sheetNo,rowIndex);
            System.out.println(headMap);
        }
        @Override
        public void onException(Exception exception, AnalysisContext context) throws Exception {
            ReadSheetHolder readSheetHolder = context.readSheetHolder();
            ReadRowHolder readRowHolder = context.readRowHolder();
            Integer rowIndex = readRowHolder.getRowIndex();
            String sheetName = readSheetHolder.getSheetName();
            Integer sheetNo = readSheetHolder.getSheetNo();
            log.error("当前sheet页解析异常 sheetName：{},sheetNo:{},rowIndex：{},exception:{}",sheetName,sheetNo,rowIndex,exception);
        }
    }



    /**
     * 异步监听
     */
    public class MyExcelListener extends AnalysisEventListener<ReadData> {
        /**
         * 每隔N条存储数据库，然后清理list ，方便内存回收
         */
        private static final int BATCH_COUNT = 3000;
        /**
         * 表头列数
         */
        private static final int TITLE_COUNT = 10;

        private List<Object> list = new CopyOnWriteArrayList<>();


        @Override
        public void invoke(ReadData data, AnalysisContext context) {
            list.add(data);
            if (list.size() >= BATCH_COUNT) {
                log.info("---->解析3000条,入库一次");
                //todo 入库
                list.clear();
            }
        }

        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            if (list.size() > 0) {
                //todo 剩余数入库
                log.info("---->剩余数入库,size:[{}]", list.size());
            }
            log.info("<--所有数据解析完成");
        }

        @Override
        public void invokeHeadMap(Map headMap, AnalysisContext context) {
            if (headMap.size() == TITLE_COUNT) {
                log.info("-->表头数据headMap:[{}]", headMap);
            }
        }
    }
}


@Data
class ImportTest {
    @ExcelProperty(value = "名称",index = 0)
    private String name;
}