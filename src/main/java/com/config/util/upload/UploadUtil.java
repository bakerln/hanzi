package com.config.util.upload;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

/**
 * Created by LiNan on 2018-06-01.
 * Description:
 */
public class UploadUtil {

    /**
     * 上传文件
     * @param file
     * @return
     * @throws IOException
     */
    public static String uploadFile(CommonsMultipartFile file){
        long startTime = System.currentTimeMillis();
        System.out.println("fileName：" + file.getOriginalFilename());
        String path = "D:/" + new Date().getTime() + file.getOriginalFilename();

        File newFile = new File(path);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        try {
            file.transferTo(newFile);
            long endTime = System.currentTimeMillis();
            System.out.println("运行时间：" + String.valueOf(endTime - startTime) + "ms");
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 读取文件
     * @param file
     * @return
     */
    public static String readFile( CommonsMultipartFile file){
        StringBuffer sb = new StringBuffer();
        try {
            InputStreamReader isr = new InputStreamReader(file.getInputStream(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String lineTxt;
            while ((lineTxt = br.readLine()) != null) {
                sb.append(lineTxt);
            }
            br.close();
            System.out.println(sb.toString());
        } catch (Exception e) {
            System.out.println("文件读取错误!");
            return "read file error";
        }
        return sb.toString();
    }
}
