package com.config.filter;


import com.config.util.session.UserSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by LiNan on 2018-05-29.
 * Description:
 */
public class HttpFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger("testLog");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();

        logger.info("HttpFilter中的session的id是: " + session.getId());

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
