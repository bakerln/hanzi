package com.display.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LiNan on 2018-05-28.
 * Description:
 */
@RequestMapping(value = "/")
@Controller
public class IndexController {

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }


    @RequestMapping(value = "detail")
    public ModelAndView detail(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("detail");
        return mv;
    }

//    @RequestMapping(value = "hello")
//    public String hello (){
//        return "redirect:/pages/index.html";
//    }
}
