package com.update.controller;

import com.update.service.UpdateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LiNan on 2018-05-31.
 * Description:
 */
@Controller
@RequestMapping(value = "/update")
public class UpdateController {


    @Autowired
    private UpdateDao updateDao;

    @RequestMapping(value = "/hanzi")
    public String jiaru(){
        updateDao.jiaru();
        return "hello";
    }
}
