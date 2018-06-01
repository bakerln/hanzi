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
 * Description:
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
    public void json(HttpServletResponse response,@RequestParam("file") CommonsMultipartFile file) throws IOException {

        String json = UploadUtil.readFile(file);

        HashMap<String,HashMap> hanzi_jsonMap = (HashMap) JsonUtil.toObject(json,HashMap.class);

        uploadService.json(hanzi_jsonMap);

        WebUtil.out(response,"upload success!");

    }
}
