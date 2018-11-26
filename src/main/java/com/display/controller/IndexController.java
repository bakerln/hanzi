package com.display.controller;

import com.display.service.IndexService;
import com.system.dto.UserLoginDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    //没用
    @RequestMapping(value = "/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }


    @RequestMapping(value = "/index")
    public ModelAndView index(UserLoginDTO userLoginDTO){
        ModelAndView mv = new ModelAndView();
        try{
            indexService.login(userLoginDTO.getPassword());
            mv.setViewName("index");
        }catch (IncorrectCredentialsException ice) {
            mv.setViewName("error_login");
        }catch (Exception e) {
            mv.setViewName("login");
        }
        return mv;
    }

    //汉字查询
    @RequestMapping(value = "detail")
    public ModelAndView detail(String hanzi){
        ModelAndView mv = new ModelAndView();
        Session session = SecurityUtils.getSubject().getSession();
        if (null != session){
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
        }else {
            mv.setViewName("login");
        }
        return mv;
    }

    //拼音查询
    @RequestMapping(value = "pinyin")
    public ModelAndView pinyin(String hanzi){
        ModelAndView mv = new ModelAndView();
        Session session = SecurityUtils.getSubject().getSession();
        if(null != session && "guest".equals(session.getAttribute("ShiroSession").toString())){
            mv.addObject("url","http://product.dangdang.com/25329067.html");
            mv.setViewName("buy");
        }else if(null != session){
            Map result = indexService.pinyin(hanzi);
            if (result != null){
                //获得笔画
                mv.setViewName("spell");
                mv.addObject("hanzi",hanzi);
                mv.addObject("result",result);
                return mv;
            }
        }else{
            mv.setViewName("index");
        }
        return mv;

    }

    //部首查询
    //部首查询首页
    @RequestMapping(value = "bushouIndex")
    public ModelAndView bushouIndex(){
        ModelAndView mv = new ModelAndView();
        Session session = SecurityUtils.getSubject().getSession();
        if(null != session && "guest".equals(session.getAttribute("ShiroSession").toString())){
            mv.addObject("url","https://item.jd.com/12425638.html");
            mv.setViewName("buy");
        }else if (null != session){
            Map result = indexService.bushouIndex();
            mv.setViewName("radical");
            mv.addObject("result",result);
        }else{
            mv.setViewName("index");
        }
        return mv;

    }

    //部首所属汉字
    @RequestMapping(value = "bushou")
    /**
    @param hanzi :部首ID
     */
    public ModelAndView bushou(String hanzi){
        ModelAndView mv = new ModelAndView();
        Session session = SecurityUtils.getSubject().getSession();
        if(null != session){
            Map result = indexService.bushou(hanzi);
            mv.setViewName("radicalDetail");
            mv.addObject("result",result);
            mv.addObject("hanzi",result.get("bushou"));
        }else{
            mv.setViewName("index");
        }
        return mv;

    }

}
