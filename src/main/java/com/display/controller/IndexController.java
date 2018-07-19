package com.display.controller;

import com.config.util.session.SessionUtil;
import com.config.util.session.UserSession;
import com.config.util.string.StringUtil;
import com.display.service.IndexService;
import com.system.dto.UserLoginDTO;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping(value = "search")
    public ModelAndView search(HttpServletRequest request,UserLoginDTO userLoginDTO){
        ModelAndView mv = new ModelAndView();
        UserSession userSession = SessionUtil.getUserSession(request);
        if (null != userSession){
            userLoginDTO.setPassword(userSession.getPassword());
        }
        //判断登陆密码
        Boolean flag = indexService.password(userLoginDTO.getPassword());
        if (flag){
            //处理用户请求所带信息
            UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
            userLoginDTO.setIp(StringUtil.getIp(request));
            userLoginDTO.setClient_browser_info(userAgent.getBrowser().toString());
            userLoginDTO.setClient_os_info(userAgent.getOperatingSystem().toString());
            userSession = new UserSession();
            userSession.setPassword(userLoginDTO.getPassword());
            SessionUtil.addSession("userSession",userSession,request);
            mv.setViewName("index");
        }else{
            mv.setViewName("error_login");
        }
        return mv;
    }

    //汉字查询
    @RequestMapping(value = "detail")
    public ModelAndView detail(String hanzi,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        UserSession userSession = SessionUtil.getUserSession(request);
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

    //拼音查询
    @RequestMapping(value = "pinyin")
    public ModelAndView pinyin(String hanzi,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        UserSession userSession = SessionUtil.getUserSession(request);
        if (null != userSession){
            Map result = indexService.pinyin(hanzi);
            if (result != null){
                //获得笔画
                mv.setViewName("spell");
                mv.addObject("hanzi",hanzi);
                mv.addObject("result",result);
                return mv;
            }
            mv.setViewName("error");
        }else {
            mv.setViewName("login");
        }
        return mv;
    }

    //部首查询
    //部首查询首页
    @RequestMapping(value = "bushouIndex")
    public ModelAndView bushouIndex(HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        UserSession userSession = SessionUtil.getUserSession(request);
        if (null != userSession){
            Map result = indexService.bushouIndex();
            mv.setViewName("radical");
            mv.addObject("result",result);
        }else {
            mv.setViewName("login");
        }
        return mv;
    }

    //部首所属汉字
    @RequestMapping(value = "bushou")
    public ModelAndView bushou(String hanzi,HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        UserSession userSession = SessionUtil.getUserSession(request);
        if (null != userSession){
            Map result = indexService.bushou(hanzi);
            mv.setViewName("radicalDetail");
            mv.addObject("result",result);
            mv.addObject("hanzi",result.get("bushou"));
        }else {
            mv.setViewName("login");
        }
        return mv;
    }

}
