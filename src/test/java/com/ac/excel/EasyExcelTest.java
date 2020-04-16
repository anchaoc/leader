package com.ac.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.google.common.primitives.Doubles;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.Test;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
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
     * 标准异步读取读取测试
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
     * 特殊异步读取读取测试
     */
    @Test
    public void excelTest2(){
        File file = new File("C:\\Users\\anchao\\Desktop\\中税任务备份\\excel公式\\2020-3-29公式修订后版-工作底稿与申报表及调整汇总等全部链接V8 - 副本.xlsx");
        ExcelListener myExcelListener = new ExcelListener();
        EasyExcel.read(file,myExcelListener)
                .sheet(5)
                .doRead();
    }






    public class ExcelListener extends AnalysisEventListener<Map<Integer,String>>{
        @Override
        public void invoke(Map<Integer,String> data, AnalysisContext context) {
            for (Map.Entry<Integer, String> entry : data.entrySet()) {
                Integer k = entry.getKey();
                String v = entry.getValue();
                if (ObjectUtils.isEmpty(entry.getValue())) {
                    log.warn("-->解析时发现空值：entry：{}",entry);
                    continue;
                }
                if (Doubles.tryParse(v)!=null) {
                    log.info("-->double :{}",Double.valueOf(v));
                }else{
                    log.info("-->String :{}",v);
                }
            }
        }
        @Override
        public void doAfterAllAnalysed(AnalysisContext context) {
            log.info("--> ok");
        }

        @Override
        public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
            log.info("--> invokeHeadMap");
        }
        @Override
        public void onException(Exception exception, AnalysisContext context) throws Exception {
            log.error("->error: ",exception);
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
