package com.ac.poi.word;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anchao
 * @date 2020/5/28 14:26
 **/
public class Test {

    public static void main(String[] args){
            InputStream is = null;
            FileOutputStream fos = null;
            try {
                //获取docx解析对象
                is = new FileInputStream("C:\\Users\\anchao\\Desktop\\企业所得税汇算清缴纳税风险报告_模板.docx");
                XWPFDocument document = new XWPFDocument(is);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("涉税风险指标");
                stringBuilder.append("\r\n");
                for (int i = 1; i <=60 ; i++) {
                    stringBuilder.append(i+"、汇总纳税企业总机构未正确填报表单");
                    stringBuilder.append("\r\n");
                    stringBuilder.append("数据来源："+"xxxxx");
                    stringBuilder.append("\r\n");
                    stringBuilder.append("提示信息："+"eeeeeeee");
                    stringBuilder.append("\r\n");
                }
                Map<String, Object> contentMap = new HashMap<>(2);
                contentMap.put("data", stringBuilder.toString());
                contentMap.put("localDateTime", "2020年5月31日");
                //解析替换段落文本对象
                XWPFUtils.changeParagraph(document, contentMap);
                //生成新的word文档
                String fileName = "XXX" +"-"+System.currentTimeMillis()+ ".docx";
                File file = new File("C:\\Users\\anchao\\Desktop\\" + fileName);
                fos = new FileOutputStream(file);
                document.write(fos);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(is);
                IOUtils.closeQuietly(fos);
            }
    }
}
