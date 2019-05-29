package com.web.controller;

import com.config.util.session.UserSession;
import com.web.service.IndexService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by LiNan on 2018-05-28.
 * Description:
 */
@RequestMapping(value = "/web")
@Controller
public class IndexController {
    private static Logger logger = LoggerFactory.getLogger("operationLog");
    @Autowired
    private IndexService indexService;


    /**
     * 汉字查询 (详细页面)
     * @param hanzi
     * @return
     */
    @RequestMapping(value = "/detail")
    public ModelAndView detail(String hanzi){
        ModelAndView mv = new ModelAndView();
        UserSession userSession = (UserSession) SecurityUtils.getSubject().getSession().getAttribute("userSession");
        logger.info(new Date() + "  user : " + userSession.getUsername() +
                " 使用 "+ userSession.getClient_os_info() + " 进行汉字查询");
        if (null != userSession){
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


    /**
     * 拼音查询
     * @param hanzi
     * @return
     */
    @RequestMapping(value = "/pinyin")
    public ModelAndView pinyin(String hanzi){
        ModelAndView mv = new ModelAndView();
        UserSession userSession = (UserSession) SecurityUtils.getSubject().getSession().getAttribute("userSession");
        logger.info(new Date() + "  user : " + userSession.getUsername() +
                " 使用 "+ userSession.getClient_os_info() + " 进行拼音查询");

        if (null == userSession){
            mv.setViewName("index");
        }else if ("guest".equals(userSession.getUsername())){
            mv.addObject("url","http://product.dangdang.com/25329067.html");
            mv.setViewName("buy");
        }else{
            Map result = indexService.pinyin(hanzi);
            if (result != null){
                //获得笔画
                mv.setViewName("spell");
                mv.addObject("hanzi",hanzi);
                mv.addObject("result",result);
                return mv;
            }
        }
        return mv;

    }


    /**
     * 部首查询页
     * @return
     */
    @RequestMapping(value = "/bushouIndex")
    public ModelAndView bushouIndex(){
        ModelAndView mv = new ModelAndView();
        Session session = SecurityUtils.getSubject().getSession();
        UserSession userSession = (UserSession) SecurityUtils.getSubject().getSession().getAttribute("userSession");
        logger.info(new Date() + "  user : " + userSession.getUsername() +
                " 使用 "+ userSession.getClient_os_info() + " 进行部首查询");

        if (userSession == null){
            mv.setViewName("index");
        }else if ("guest".equals(userSession.getUsername())){
            mv.addObject("url","https://item.jd.com/12425638.html");
            mv.setViewName("buy");
        }else {
            Map result = indexService.bushouIndex();
            mv.setViewName("radical");
            mv.addObject("result",result);
        }
        return mv;
    }

    /**
     * 部首所属汉字
     @param hanzi :部首ID
     */
    @RequestMapping(value = "/bushou")
    public ModelAndView bushou(String hanzi){
        ModelAndView mv = new ModelAndView();
        UserSession userSession = (UserSession) SecurityUtils.getSubject().getSession().getAttribute("userSession");
        if(null != userSession){
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
