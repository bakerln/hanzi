package com.config.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by linan on 2018-11-26.
 * Description:
 */
@WebListener
public class SessionListener implements HttpSessionListener {
    private static Logger logger = LoggerFactory.getLogger("testLog");
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        //当session创建时HttpSessionEvent为httpsession事件
        Integer onlinePeopleNum = 0;//初始化参数定义为封装类，因为下面还要向
        Object object = httpSessionEvent.getSession().getServletContext().getAttribute("onlinePeopleNum");
        //从servletContext中获取原来初始数，使用object类接收
        if(object != null){
            onlinePeopleNum = (Integer) object;
            //如果原来不为空，则将servletContext中的数量赋值给onlinePeopleNum
        }
        logger.info("登录时人数： " + onlinePeopleNum.toString());
        //创建则人数加一
        onlinePeopleNum++;
        httpSessionEvent.getSession().getServletContext().setAttribute("onlinePeopleNum", onlinePeopleNum);
        //将新数重新赋值回servletContext中
        /*
         * 注：servletContext作用域为全站，所以将其存入其中，使用时再取出即可
         */

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        Integer onlinePeopleNum = (Integer)httpSessionEvent.getSession().getServletContext().getAttribute("onlinePeopleNum");
        //销毁则人数减一
        onlinePeopleNum--;
        logger.info("登出后人数： " + onlinePeopleNum.toString());
        httpSessionEvent.getSession().getServletContext().setAttribute("onlinePeopleNum", onlinePeopleNum);

    }
}
