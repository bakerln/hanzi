package com.config.filter;


import com.config.util.session.UserSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LiNan on 2018-05-29.
 * Description:
 */
public class HttpFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        System.out.println("Filter中的session的id是====" + session.getId());
        Session session1 = SecurityUtils.getSubject().getSession();
        //TODO 查看req中的session是否能取到ShiroSession
        UserSession userSession = (UserSession) session.getAttribute("ShiroSession");
        if (null != userSession){
            System.out.println("登录用户为====" + userSession.getUsername());
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
