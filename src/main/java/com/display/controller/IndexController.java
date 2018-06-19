package com.display.controller;

import com.config.util.web.WebUtil;
import com.display.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by LiNan on 2018-05-28.
 * Description:
 */
@RequestMapping(value = "/")
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    //汉字查询 c1
    @RequestMapping(value = "detail")
    public ModelAndView detail(String hanzi){
        ModelAndView mv = new ModelAndView();
        Map result = indexService.detail(hanzi);
        if (result != null){
            //获得笔画
            List list = indexService.getBihua((String)result.get("hanzi"));
            mv.addObject("bihua",list);
            mv.addObject("hanzi",result);
            mv.setViewName("detail");
            return mv;
        }
        mv.setViewName("error");
        return mv;
    }



    //TODO tag 为c2：拼音查询
    @RequestMapping(value = "pinying")
    public ModelAndView pinying(String hanzi, HttpServletResponse response){
        WebUtil.out(response,"pinying");
        return null;
    }

    //TODO tag 为c3：部首查询
    @RequestMapping(value = "bushou")
    public ModelAndView bushou(String hanzi,HttpServletResponse response){
        WebUtil.out(response,"bushou");
        return null;
    }

}
