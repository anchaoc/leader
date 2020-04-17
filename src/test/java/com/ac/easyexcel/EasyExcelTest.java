package com.ac.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.metadata.holder.ReadRowHolder;
import com.alibaba.excel.read.metadata.holder.ReadSheetHolder;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.IndexedColors;
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
    public void excelTest3(){
        List<WriteData> writeDataList = Collections.singletonList(new WriteData("a", 16));
        WriteCellStyle writeCellStyle = new WriteCellStyle();
        writeCellStyle.setBottomBorderColor(IndexedColors.GOLD.index);
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = new HorizontalCellStyleStrategy(writeCellStyle,writeCellStyle);
        EasyExcel
                .write("C:\\Users\\anchao\\Desktop\\"+System.currentTimeMillis()+".xlsx", WriteData.class)
                .useDefaultStyle(false)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("sheet1")
                .doWrite(writeDataList);
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
