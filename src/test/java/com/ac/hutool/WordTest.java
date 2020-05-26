package com.ac.hutool;

import cn.hutool.poi.word.Word07Writer;
import cn.hutool.poi.word.WordUtil;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;

import java.awt.*;
import java.io.File;

/**
 * @author anchao
 * @date 2020/5/12 9:52
 **/
public class WordTest {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\anchao\\Desktop\\"+System.currentTimeMillis()+"测试word.doc");
        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = e.getAvailableFontFamilyNames();
        Font font = new Font(fontNames[0],Font.PLAIN,10);
        Word07Writer word07Writer = WordUtil.getWriter(file);
        word07Writer.addText(ParagraphAlignment.LEFT, font, "haha_@#%4你好1");
        word07Writer.addText(ParagraphAlignment.LEFT, font, "haha_@#%4你好2");
        word07Writer.addText(ParagraphAlignment.LEFT, font, "haha_@#%4你好3");
        word07Writer.flush().close();
    }
}
