package com.Shiro.controller;

import com.Shiro.service.ShiroService;
import com.config.util.session.SessionUtil;
import com.config.util.session.UserSession;
import com.config.util.string.StringUtil;
import com.system.dto.UserLoginDTO;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiNan on 2018-11-22.
 * Description:
 */
@Controller
@RequestMapping(value = "/shiro")
public class ShiroController {


    private static Logger logger = LoggerFactory.getLogger("testLog");

    @Autowired
    private ShiroService shiroService;



}
