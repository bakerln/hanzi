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
        /*
         * 注：servletContext作用域为全站，所以将其存入其中，使用时再取出即可
         */
        Integer onlinePeopleNum;//初始化参数定义为封装类，因为下面还要向
        Object object = httpSessionEvent.getSession().getServletContext().getAttribute("onlinePeopleNum");
        if(object != null){
            //如果原来不为空，则将servletContext中的数量赋值给onlinePeopleNum
            onlinePeopleNum = (Integer) object + 1;
        }else {
            //第一次启动
            onlinePeopleNum = 0;
        }
        logger.info("当前登录时人数： " + onlinePeopleNum.toString());
        //将新数重新赋值回servletContext中
        httpSessionEvent.getSession().getServletContext().setAttribute("onlinePeopleNum", onlinePeopleNum);

        /*
         * session作用域
         */
        httpSessionEvent.getSession().setAttribute("times",5);

        //1天
        httpSessionEvent.getSession().setMaxInactiveInterval(24*60*60);
        logger.info( httpSessionEvent.getSession().getId());


    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        Integer onlinePeopleNum = (Integer)httpSessionEvent.getSession().getServletContext().getAttribute("onlinePeopleNum");
        //销毁则人数减一
        //TODO 没有登录的也算了
        if(onlinePeopleNum > 0){
            onlinePeopleNum--;
        }
        logger.info("登出后人数： " + onlinePeopleNum.toString());
        httpSessionEvent.getSession().getServletContext().setAttribute("onlinePeopleNum", onlinePeopleNum);

        logger.info( httpSessionEvent.getSession().getId() +" session 销毁");
        httpSessionEvent.getSession().invalidate();
    }
}
