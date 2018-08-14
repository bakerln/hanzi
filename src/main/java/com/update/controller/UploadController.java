package com.update.controller;

import com.config.util.json.JsonUtil;
import com.config.util.upload.UploadUtil;
import com.config.util.web.WebUtil;
import com.update.service.AsyncTaskService;
import com.update.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LiNan on 2018-06-01.
 * Description: 导入数据
 */
@Controller
@RequestMapping(value = "/backdoor/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @Autowired
    private AsyncTaskService asyncTaskService;

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("readJson");
        return mv;
    }

    /**
     * 读取3500字的笔画读音部首
     * （网上扒的数据）
     * @param response
     * @param file
     */
    @RequestMapping(value = "/json")
    public void json(HttpServletResponse response,@RequestParam("file") CommonsMultipartFile file){
        String json = UploadUtil.readFile(file);
        HashMap<String,HashMap> hanzi_jsonMap = (HashMap) JsonUtil.toObject(json,HashMap.class);
//        uploadService.json(hanzi_jsonMap);
        WebUtil.out(response,"upload success!");
    }


    /**
     * 读取excel中的笔画、结构信息
     * 读取excel中的3500汉字笔画、结构对应关系
     * 读取excel中的拼音
     * @param response
     * @param file
     */

    @RequestMapping(value = "/excel")
    public void excel(HttpServletResponse response,@RequestParam("file") CommonsMultipartFile file){
        //获取文件名
        String name = file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size = file.getSize();
        if(name == null || ("").equals(name) && size==0) System.out.println("---------null file---------");

        //读取excel中的笔画、结构信息
//        uploadService.excelBIHUA(name,file);
        //上传汉字
//        uploadService.excelHANZI(name,file);
        //读取拼音
//        uploadService.excelPINYIN(name,file);
        //读取部首
//        uploadService.excelBUSHOU(name,file);
        //读取多开门部首
//        uploadService.excelDUOKAIMEN(name,file);
        //读取部首顺序
//        uploadService.excelBUSHOU_NO(name,file);
        WebUtil.out(response,"upload success!");
    }


    /**
     * 读取tips
     * @param response
     * @param file
     */
    @RequestMapping(value = "/word")
    public void word(HttpServletResponse response,@RequestParam("file") CommonsMultipartFile file){
        //获取文件名
        String name=file.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=file.getSize();
        if(name==null || ("").equals(name) && size==0) System.out.println("---------null file---------");
//        uploadService.wordHANZI(name,file);
        WebUtil.out(response,"upload success!");
    }


    /**
     * 导入汉字以及汉字编号
     * @return
     */
    @RequestMapping(value = "/input")
    @ResponseBody
    public String input(){
        List list = uploadService.hanziIDList();
//        uploadService.input(list);
        return "success! ";
    }


    @RequestMapping(value = "/test")
    @ResponseBody
    public String test(String name){
        uploadService.test(name);
        for (int i = 0 ;i<10;i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }

        return "hello";
    }

    @RequestMapping(value = "/password")
    @ResponseBody
    public String password(HttpServletResponse response){
        int num = 100000;
//        uploadService.getPassword(response,num);
        return "success";
    }

    @RequestMapping(value = "/geshi")
    public String geshi(HttpServletResponse response){
        uploadService.geshi();
        return "success";
    }

}
