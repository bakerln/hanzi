package com.update.controller;

import com.config.util.json.JsonUtil;
import com.config.util.upload.UploadUtil;
import com.config.util.web.WebUtil;
import com.update.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * Created by LiNan on 2018-06-01.
 * Description: 导入数据
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;


    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("readJson");
        return mv;
    }

    @RequestMapping(value = "/json")
    public void json(HttpServletResponse response,@RequestParam("file") CommonsMultipartFile file){
        String json = UploadUtil.readFile(file);
        HashMap<String,HashMap> hanzi_jsonMap = (HashMap) JsonUtil.toObject(json,HashMap.class);
        uploadService.json(hanzi_jsonMap);
        WebUtil.out(response,"upload success!");

    }

    @RequestMapping(value = "/excel")
    public void excel(HttpServletResponse response,@RequestParam("file") CommonsMultipartFile file){
        //获取文件名
        String name=file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0) System.out.println("---------null file---------");
        //上传笔画
//        uploadService.excelBIHUA(name,file);
        //上传汉字
        uploadService.excelHANZI(name,file);
        WebUtil.out(response,"upload success!");
    }

    @RequestMapping(value = "/word")
    public void word(HttpServletResponse response,@RequestParam("file") CommonsMultipartFile file){
        //获取文件名
        String name=file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0) System.out.println("---------null file---------");

        uploadService.wordHANZI(name,file);
        WebUtil.out(response,"upload success!");

    }
}
