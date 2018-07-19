package com.config.filter;


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
//        System.out.println("Filter中的session的id是====" + session.getId());
//        UserSession userSession = (UserSession) session.getAttribute("userSession");
//        if (null != userSession){
//            System.out.println("登录用户为====" + userSession.getUsername());
//        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
