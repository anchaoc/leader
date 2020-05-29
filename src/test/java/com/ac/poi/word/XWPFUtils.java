package com.ac.poi.word;

import com.alibaba.fastjson.JSON;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlToken;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * word导出util
 */
public class XWPFUtils {

    private static Logger logger = LoggerFactory.getLogger(XWPFUtils.class);

    /**
     * 根据模板生成word文档
     *
     * @param os
     * @param tempPath
     * @param contentMap
     */
    public static void writeTemp(OutputStream os, String tempPath, Map<String, Object> contentMap) {
        logger.info("---根据模板生成word文档");
        logger.info("---模板地址：{}", tempPath);
        logger.info("---替换内容：{}", JSON.toJSONString(contentMap));
        ClassPathResource resource = new ClassPathResource(tempPath);
        if (resource == null || !resource.exists()) {
            logger.error("---模板文件不存在，tempPath：{}", tempPath);
            return;
        }

        InputStream is = null;
        try {
            is = resource.getInputStream();
            XWPFDocument document = new XWPFDocument(is);
            XWPFUtils.changeParagraph(document, contentMap);
            //生成新的word文档
            document.write(os);
        } catch (IOException e) {
            logger.error("---输出word文档失败,原因：{}", e.getMessage());
        } finally {
            IOUtils.closeQuietly(is);
        }
    }


    /**
     * 替换段落文本
     *
     * @param document docx解析对象
     * @param textMap  需要替换的信息集合
     */
    public static void changeParagraph(XWPFDocument document, Map<String, Object> textMap) {
        //获取段落集合
        List<XWPFParagraph> paragraphs = document.getParagraphs();

        for (XWPFParagraph paragraph : paragraphs) {
            List<XWPFRun> runs = paragraph.getRuns();
            for (XWPFRun run : runs) {
                String text = run.getText(0);
                //判断文本是否需要进行替换
                if (checkText(text)) {
                    for (Map.Entry<String, Object> entry : textMap.entrySet()) {
                        //匹配模板与替换值 格式${key}
                        String key = "${" + entry.getKey() + "}";
                        Object value = entry.getValue();

                        if (text.contains(key)) {
                            if (value instanceof String) { //文字替换
                                text = text.replace(key, (String) value);
                            } else if (value instanceof Map) { //图片替换
                                text = text.replace(key, "");
                                Map picMap = (Map) value;
                                int width = Integer.parseInt(picMap.get("width").toString());
                                int height = Integer.parseInt(picMap.get("height").toString());
                                int picType = getPictureType(picMap.get("type").toString());
                                FileInputStream fis = (FileInputStream) picMap.get("content");
                                try {
                                    String blipId = document.addPictureData(fis, picType);
                                    int id = document.getNextPicNameNumber(picType);
                                    XWPFUtils.createPicture(id, blipId, width, height, run);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                    //替换模板原来位置
                    run.setText(text, 0);
                }
            }
        }
    }

    /**
     * @param id
     * @param blipId
     * @param width  宽
     * @param height 高
     *               //* @param paragraph  段落
     */
    private static void createPicture(int id, String blipId, int width, int height, XWPFRun xwpfRun) {
        final int EMU = 9525;
        width *= EMU;
        height *= EMU;
        CTInline inline = xwpfRun.getCTR().addNewDrawing().addNewInline();
        //CTInline inline = paragraph.createRun().getCTR().addNewDrawing().addNewInline(); //在遍历run列表的时候，创建新的run有可能会导致报错
        String picXml = ""
                + "<a:graphic xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\">"
                + "   <a:graphicData uri=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">"
                + "      <pic:pic xmlns:pic=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">"
                + "         <pic:nvPicPr>" + "            <pic:cNvPr id=\""
                + id
                + "\" name=\"Generated\"/>"
                + "            <pic:cNvPicPr/>"
                + "         </pic:nvPicPr>"
                + "         <pic:blipFill>"
                + "            <a:blip r:embed=\""
                + blipId
                + "\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"/>"
                + "            <a:stretch>"
                + "               <a:fillRect/>"
                + "            </a:stretch>"
                + "         </pic:blipFill>"
                + "         <pic:spPr>"
                + "            <a:xfrm>"
                + "               <a:off x=\"0\" y=\"0\"/>"
                + "               <a:ext cx=\""
                + width
                + "\" cy=\""
                + height
                + "\"/>"
                + "            </a:xfrm>"
                + "            <a:prstGeom prst=\"rect\">"
                + "               <a:avLst/>"
                + "            </a:prstGeom>"
                + "         </pic:spPr>"
                + "      </pic:pic>"
                + "   </a:graphicData>" + "</a:graphic>";

        inline.addNewGraphic().addNewGraphicData();
        XmlToken xmlToken = null;
        try {
            xmlToken = XmlToken.Factory.parse(picXml);
        } catch (XmlException xe) {
            xe.printStackTrace();
        }
        inline.set(xmlToken);

        inline.setDistT(0);
        inline.setDistB(0);
        inline.setDistL(0);
        inline.setDistR(0);

        CTPositiveSize2D extent = inline.addNewExtent();
        extent.setCx(width);
        extent.setCy(height);

        CTNonVisualDrawingProps docPr = inline.addNewDocPr();
        docPr.setId(id);
        docPr.setName("docx_img_ " + id);
        docPr.setDescr("docx Picture");
    }

    /**
     * 判断文本中是否包含$
     *
     * @param text 文本
     * @return 包含返回true, 不包含返回false
     */
    private static boolean checkText(String text) {
        if (text == null || "".equals(text)) {
            return false;
        }
        return text.contains("$");
    }

    /**
     * 根据图片类型，取得对应的图片类型代码
     *
     * @param picType
     * @return int
     */
    private static int getPictureType(String picType) {
        int res = XWPFDocument.PICTURE_TYPE_PICT;
        if (picType != null) {
            if (picType.equalsIgnoreCase("png")) {
                res = XWPFDocument.PICTURE_TYPE_PNG;
            } else if (picType.equalsIgnoreCase("dib")) {
                res = XWPFDocument.PICTURE_TYPE_DIB;
            } else if (picType.equalsIgnoreCase("emf")) {
                res = XWPFDocument.PICTURE_TYPE_EMF;
            } else if (picType.equalsIgnoreCase("jpg") || picType.equalsIgnoreCase("jpeg")) {
                res = XWPFDocument.PICTURE_TYPE_JPEG;
            } else if (picType.equalsIgnoreCase("wmf")) {
                res = XWPFDocument.PICTURE_TYPE_WMF;
            }
        }
        return res;
    }
}