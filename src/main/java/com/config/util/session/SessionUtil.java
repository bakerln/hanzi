package com.config.util.session;


import com.config.util.global.GlobalConst;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by LiNan on 2018-01-09.
 * Description:
 */
public class SessionUtil {

    public static UserSession getUserSession(HttpServletRequest request){
        if (request.getSession().getAttribute("userSession") != null ){
            return (UserSession) request.getSession().getAttribute("userSession");
        }else{
            return null;
        }
    }

    public static void addSession(String name, Object object, HttpServletRequest request) {
        request.getSession().setAttribute("userSession", object);
        request.getSession().setMaxInactiveInterval(GlobalConst.SessionTimeOut);
    }
}
