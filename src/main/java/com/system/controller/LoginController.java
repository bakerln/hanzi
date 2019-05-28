package com.system.controller;

import com.system.dto.UserLoginDTO;
import com.system.service.SysService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;

/**
 * Created by linan on 2019-04-24
 * Description:
 */

@RequestMapping(value = "/")
@Controller
public class LoginController {
    private static Logger logger = LoggerFactory.getLogger("operationLog");

    @Autowired
    private SysService sysService;

    /**
     * Web登录验证
     * @return
     */
    @RequestMapping(value = "index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping(value = "webLogin")
    public ModelAndView login(ServletRequest request, UserLoginDTO userLoginDTO){
        ModelAndView mv = new ModelAndView();

        //登录人数统计
        String onlinePeopleNum = request.getServletContext().getAttribute("onlinePeopleNum").toString();

        userLoginDTO.setClient_os_info("00");
        try{
            sysService.login(userLoginDTO);
            mv.addObject("onlinePeopleNum",onlinePeopleNum);
            mv.setViewName("index");
        }catch (IncorrectCredentialsException ice) {
            mv.setViewName("error_login");
        }catch (Exception e) {
            mv.setViewName("login");
        }
        return mv;
    }
    //TODO 退出登录


    /**
     * WAP登录验证
     */
}
