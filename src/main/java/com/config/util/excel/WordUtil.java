package com.config.util.excel;

import org.apache.poi.hslf.record.Document;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiNan on 2018-06-05.
 * Description:
 */
@Component
public class WordUtil {
    /**
     * 描述：是否是2003的excel，返回true是2003
     */
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(doc)$");
    }

    /**
     * 描述：是否是2007的excel，返回true是2007
     */
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(docx)$");
    }

    /**
     * 验证Word文件
     * @param filePath
     * @return
     */
    public static String validateExcel(String filePath) {
        if (isExcel2007(filePath)) {
            return "2007";
        } else {
            return "2003";
        }
    }

    /**
     * 读Word文件，获取tips信息
     * @param fileName
     * @param file
     * @return
     */
    public List getWordTips(String fileName, CommonsMultipartFile file) {
        List<String> list = new ArrayList<>();

        try {
            //初始化输入流
            InputStream is = file.getInputStream();

            //创建Workbook的方式
            if ("2007".equals(validateExcel(fileName))) {
                XWPFDocument document = new XWPFDocument(is);
                //获取paragraphs
                List<XWPFParagraph> paragraphs = document.getParagraphs();
                for(XWPFParagraph paragraph : paragraphs){
                    String text = paragraph.getParagraphText();
                    list.add(text);
                    //继续取每段内容
//                    List<XWPFRun> runs = paragraph.getRuns();
//                    for(XWPFRun run : runs){
//                        if(run.getCTR().xmlText().indexOf("<w:drawing>")!=-1){
//                            String runXmlText = run.getCTR().xmlText();
//                            int rIdIndex = runXmlText.indexOf("r:embed");
//                            int rIdEndIndex = runXmlText.indexOf("/>", rIdIndex);
//                            String rIdText = runXmlText.substring(rIdIndex, rIdEndIndex);
//                            System.out.println(rIdText.split("\"")[1].substring("rId".length()));
//                            String id = rIdText.split("\"")[1];
//                        }else{
//                            text = text + run;
//                        }
//                    }
                }
                return list;
            } else if ("2003".equals(validateExcel(fileName))) {
                WordExtractor extractor = new WordExtractor(is);
                String text = extractor.getText();
            } else return null;

            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
