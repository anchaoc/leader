package com.ac.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
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
     * 异步读取读取测试
     */
    @Test
    public void excelTest() {
        File file = new File("C:\\Users\\anchao\\Desktop\\中税任务备份\\审计分录任务\\8万行序时账.xlsx");
        MyExcelListener myExcelListener = new MyExcelListener();
        EasyExcel.read(file, MyData.class, myExcelListener)
                .sheet(0)
                .headRowNumber(5)
                .doRead();
    }


    /**
     * 异步监听
     */
    public class MyExcelListener extends AnalysisEventListener<MyData> {
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
        public void invoke(MyData data, AnalysisContext context) {
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
