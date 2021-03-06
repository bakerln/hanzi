package com.config.util.web;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by LiNan on 2018-04-09.
 * Description:字符串操作，用于保存和Web输入输出有关的方法
 */
public class WebUtil {
    /**
     * Servlet打印字符串
     *
     * @param response
     * @param str
     */
    public static void out(HttpServletResponse response, String str) {
        response.setContentType("text/html; charset=UTF-8");
        //给前端发数据如果涉及到了跨域，需要加允许跨域的head
//        response.setHeader("Access-Control-Allow-Origin", GlobalConst.STATIC_URL);
        //带cookie，使得session一致
//        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        try {
            if (str.length() < 100)
                response.getWriter().println(str);
            else
                gzipReponse(response, str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void gzipReponse(HttpServletResponse response, String data) {
        try {
            byte[] result = data.getBytes("UTF-8");
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            GZIPOutputStream gout = new GZIPOutputStream(out);
            gout.write(data.getBytes("UTF-8"));
            gout.close();
            result = out.toByteArray();
            response.setHeader("Content-Encoding", "gzip");
            response.setHeader("Content-Length", result.length + "");
            response.getOutputStream().write(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void outExcel(HttpServletResponse response, HSSFWorkbook wb, String report_name){
        OutputStream os = null;
        try {
            response.setContentType("text/html; charset=UTF-8");//text/html; charset=UTF-8//application/msexcel
            response.reset();
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("content-disposition", "attachment; filename=" + new String(report_name.getBytes("UTF-8"), "ISO-8859-1") + ".xls");//gb2312
            System.setProperty("org.apache.poi.util.POILogger", "org.apache.poi.util.POILogger");
            os = response.getOutputStream();
            wb.write(os);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                response.flushBuffer();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }

    }

}
