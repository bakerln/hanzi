package com.system.controller;

import com.config.util.global.GlobalCode;
import com.config.util.json.JsonMsg;
import com.system.dto.UserLoginDTO;
import com.system.service.SysService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import java.util.Date;

/**
 * Created by linan on 2019-05-29
 * Description:
 */
@RestController
@RequestMapping(value = "/")
public class LoginWapController {
    private static Logger logger = LoggerFactory.getLogger("operationLog");

    @Autowired
    private SysService sysService;

    /**
     * WAP登录验证
     */
    @GetMapping(value = "wapLogin")

    public JsonMsg login(ServletRequest request, String userName,String code){
        //登录人数统计
        String onlinePeopleNum = request.getServletContext().getAttribute("onlinePeopleNum").toString();
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        userLoginDTO.setUsername(userName);
        userLoginDTO.setClient_os_info("01");
        userLoginDTO.setPassword(code);
        try{
            sysService.login(userLoginDTO);
        }catch (Exception ice) {
            logger.info(new Date()+"  "+ice.getMessage());
            return new JsonMsg(true,"用户登录失败", GlobalCode.FAIL);
        }
        return new JsonMsg(true,"登录成功",GlobalCode.SUCCESS,onlinePeopleNum);
    }
}
