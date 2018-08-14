package com.config.util.excel;

import com.update.model.Bushou;
import com.update.model.BushouNO;
import com.update.model.Hanzi;
import com.update.model.Pinyin;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiNan on 2018-06-04.
 * Description:
 */
@Component
public class ExcelUtil {

    /**
     * 描述：是否是2003的excel，返回true是2003
     */
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    /**
     * 描述：是否是2007的excel，返回true是2007
     */
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 验证EXCEL文件
     * @param filePath
     * @return
     */
    private static Workbook validateExcel(String filePath,InputStream is) throws IOException {
        if (isExcel2007(filePath)) {
            return new XSSFWorkbook(is);
        } else if (isExcel2003(filePath)){
            return new HSSFWorkbook(is);
        } else return null;
    }

    /**
     * 读EXCEL文件，获取笔画，结构信息(第三页)
     * @param fileName
     * @param file
     * @return
     */
    public Map getExcelBIHUAInfo(String fileName, CommonsMultipartFile file) {
        try {
            //初始化输入流
            InputStream is = file.getInputStream();

            //创建Workbook的方式
            Workbook wb = validateExcel(fileName,is);
//            if ("2007".equals(validateExcel(fileName))) {
//                wb = new XSSFWorkbook(is);
//            } else if ("2003".equals(validateExcel(fileName))) {
//                wb = new HSSFWorkbook(is);
//            } else return null;

            //得到shell页
            Sheet sheet = wb.getSheetAt(2);

            //得到Excel的行数
            int totalRows = sheet.getPhysicalNumberOfRows();

            //得到Excel的列数
            int totalCells = 0;

            //得到Excel的列数(前提是有行数)
            if (totalRows >= 1 && sheet.getRow(0) != null) {
                totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            }

            List<String> bihuaList = new ArrayList<String>();
            List<String> jiegouList = new ArrayList<String>();

            //循环Excel行数,从第一行开始
            for (int r = 0; r < totalRows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;
                //循环Excel的列
                for (int c = 0; c < totalCells; c++) {
                    Cell cell = row.getCell(c);
                    if (null != cell) {
                        if (c == 0) {
                            bihuaList.add(cell.getStringCellValue());//笔画
                        } else if (c == 1) {
                            jiegouList.add(cell.getStringCellValue());//结构
                        }
                    }
                }
            }
            Map content = new HashMap();
            content.put("bihuaList", bihuaList);
            content.put("jiegouList", jiegouList);
            return content;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 读EXCEL文件，获取汉字笔画关系(第四页)
     * @param fileName
     * @param file
     * @return
     */
    public List getExcelHANZIInfo(String fileName, CommonsMultipartFile file) {
        try {
            //初始化输入流
            InputStream is = file.getInputStream();

            //创建Workbook的方式
            Workbook wb = validateExcel(fileName,is);
//            Workbook wb = null;
//            if ("2007".equals(validateExcel(fileName))) {
//                wb = new XSSFWorkbook(is);
//            } else if ("2003".equals(validateExcel(fileName))) {
//                wb = new HSSFWorkbook(is);
//            } else return null;

            //得到shell页
            Sheet sheet = wb.getSheetAt(3);

            //得到Excel的行数
            int totalRows = sheet.getPhysicalNumberOfRows();

            //得到Excel的列数
            int totalCells = 0;

            //得到Excel的列数(前提是有行数)
            if (totalRows >= 1 && sheet.getRow(0) != null) {
                totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            }

            List<Hanzi> hanziList = new ArrayList<Hanzi>();

            //循环Excel行数,从第一行开始
            for (int r = 0; r < totalRows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;
                Hanzi hanzi = new Hanzi();
                //循环Excel的列
                for (int c = 0; c < totalCells; c++) {
                    Cell cell = row.getCell(c);
                    if (null != cell) {
                        if (c == 0) {
                            int num = r+1;
                            hanzi.setId(String.valueOf(num));
                            hanzi.setNum(String.valueOf(num));
                        } else if (c == 1) {
                            hanzi.setHanzi(cell.getStringCellValue());
                        } else if (c == 2) {
                            hanzi.setBihua(cell.getStringCellValue());
                        } else if (c == 3) {
                            hanzi.setJiegou(String.valueOf(cell.getNumericCellValue()));
                        }
                    }
                }
                hanziList.add(hanzi);
            }
            return hanziList;
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 读EXCEL文件，获取汉字拼音(第五页)
     * @param fileName
     * @param file
     */
    public List getExcelPINYINInfo(String fileName, CommonsMultipartFile file) {
        try {
            //初始化输入流
            InputStream is = file.getInputStream();
            //创建Workbook的方式
            Workbook wb = validateExcel(fileName,is);

            //得到shell页
            Sheet sheet = wb.getSheetAt(4);
            //得到Excel的行数
            int totalRows = sheet.getPhysicalNumberOfRows();

            //得到Excel的列数
            int totalCells = 0;

            //得到Excel的列数(前提是有行数)
            if (totalRows >= 1 && sheet.getRow(0) != null) {
                totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
            }
            List<Pinyin> pinyinList = new ArrayList<Pinyin>();

            //循环Excel行数,从第二行开始
            for (int r = 1; r < totalRows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;
                Pinyin pinyin = new Pinyin();
                //循环Excel的列
                for (int c = 0; c < totalCells; c++) {
                    Cell cell = row.getCell(c);
                    if (null != cell) {
                        if (c == 1) {
                            pinyin.setHanzi(cell.getStringCellValue());
                        } else if (c == 3) {
                            pinyin.setDuyin_1(cell.getStringCellValue());
                        } else if (c == 5) {
                            pinyin.setQinyin_1(cell.getStringCellValue());
                        }
                    }
                }
                pinyinList.add(pinyin);
            }

            return pinyinList;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 读EXCEL文件，获取汉字部首(第五页)
     * @param fileName
     * @param file
     */
    public List getExcelBushouInfo(String fileName, CommonsMultipartFile file) {
        try {
            //初始化输入流
            InputStream is = file.getInputStream();
            //创建Workbook的方式
            Workbook wb = validateExcel(fileName,is);

            //得到shell页
            Sheet sheet = wb.getSheetAt(4);
            //得到Excel的行数
            int totalRows = sheet.getPhysicalNumberOfRows();

            //得到Excel的列数
            int totalCells = 0;

            //得到Excel的列数(前提是有行数)
            if (totalRows >= 1 && sheet.getRow(0) != null) {
                totalCells = sheet.getRow(0).getPhysicalNumberOfCells();       }
            List<Bushou> buShouList = new ArrayList();

            //循环Excel行数,从第二行开始
            for (int r = 1; r < totalRows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;
                Bushou bushou = new Bushou();
                //循环Excel的列
                for (int c = 0; c < totalCells; c++) {
                    Cell cell = row.getCell(c);
                    if (null != cell) {
                        if (c == 2) {
                            bushou.setBushou(cell.getStringCellValue());
                        } else if (c == 4) {
                            bushou.setNum(String.valueOf(cell.getNumericCellValue()));
                        } else if (c == 1) {
                            bushou.setHanzi(cell.getStringCellValue());
                        }
                    }
                }
                buShouList.add(bushou);
            }

            return buShouList;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 读EXCEL文件，获取多开门(第七页)
     * @param fileName
     * @param file
     */
    public List getExcelDuoKaiMenInfo(String fileName, CommonsMultipartFile file) {
        try {
            //初始化输入流
            InputStream is = file.getInputStream();
            //创建Workbook的方式
            Workbook wb = validateExcel(fileName,is);

            //得到shell页
            Sheet sheet = wb.getSheetAt(6);
            //得到Excel的行数
            int totalRows = sheet.getPhysicalNumberOfRows();

            //得到Excel的列数
            int totalCells = 0;

            //得到Excel的列数(前提是有行数)
            if (totalRows >= 1 && sheet.getRow(0) != null) {
                totalCells = sheet.getRow(0).getPhysicalNumberOfCells();       }
            List<Hanzi> hanziList = new ArrayList();

            //循环Excel行数,从第二行开始
            for (int r = 1; r < totalRows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;
                Hanzi hanzi = new Hanzi();
                //循环Excel的列
                for (int c = 0; c < totalCells; c++) {
                    Cell cell = row.getCell(c);
                    if (null != cell) {
                        if (c == 0) {
                            hanzi.setHanzi(cell.getStringCellValue());
                        } else if (c == 1) {
                            hanzi.setBushou(cell.getStringCellValue());
                        }
                    }
                }
                hanziList.add(hanzi);
            }

            return hanziList;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 导出excel
     * @param excel
     * @param password
     * @return
     */
    public static HSSFWorkbook out(String[][] excel, String password) {
        HSSFWorkbook wb = new HSSFWorkbook();
        // sheet创建一个工作页
        HSSFSheet sheet = wb.createSheet(password);
        sheet.setDefaultColumnWidth((short) 10);

        //content Style
        HSSFCellStyle contentStyle = wb.createCellStyle();
        contentStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        contentStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        contentStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        contentStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        contentStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        contentStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        contentStyle.setWrapText(true);//自动换行
        HSSFFont contentFont = wb.createFont();//字体
        contentFont.setFontName("宋体");
        contentFont.setFontHeightInPoints((short)10);
        contentFont.setBoldweight((short) Font.BOLD);
        contentStyle.setFont(contentFont);

        for (int i = 0; i < excel.length; i++) {
            // HSSFRow,对应一行
            HSSFRow row = sheet.createRow(i+1);
            for (int j = 0; j < excel[i].length; j++) {
                // HSSFCell对应一格
                HSSFCell cell = row.createCell(j);
                cell.setCellValue(excel[i][j]);
                cell.setCellStyle(contentStyle);
            }
        }
        //完善可加入总额，考虑到不一定有意义，未加入
        return wb;
    }
    /**
     * 读EXCEL文件，获取部首顺序(第8页)
     * @param fileName
     * @param file
     */
    public List getExcelBushouNo(String fileName, CommonsMultipartFile file) {
        try {
            //初始化输入流
            InputStream is = file.getInputStream();
            //创建Workbook的方式
            Workbook wb = validateExcel(fileName,is);

            //得到shell页
            Sheet sheet = wb.getSheetAt(7);
            //得到Excel的行数
            int totalRows = sheet.getPhysicalNumberOfRows();

            //得到Excel的列数
            int totalCells = 0;

            //得到Excel的列数(前提是有行数)
            if (totalRows >= 1 && sheet.getRow(0) != null) {
                totalCells = sheet.getRow(0).getPhysicalNumberOfCells();       }
            List<BushouNO> bushouNOList = new ArrayList();

            //循环Excel行数,从第二行开始
            for (int r = 1; r < totalRows; r++) {
                Row row = sheet.getRow(r);
                if (row == null) continue;
                BushouNO bushouNO = new BushouNO();
                //循环Excel的列
                for (int c = 0; c < totalCells; c++) {
                    Cell cell = row.getCell(c);
                    if (null != cell) {
                        if (c == 0) {
                            bushouNO.setNo(String.valueOf(cell.getNumericCellValue()));
                        } else if (c == 1) {
                            bushouNO.setHanzi(cell.getStringCellValue());
                        } else if (c == 2) {
                            bushouNO.setBushou(cell.getStringCellValue());
                        }
                    }
                }
                bushouNOList.add(bushouNO);
            }

            return bushouNOList;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}