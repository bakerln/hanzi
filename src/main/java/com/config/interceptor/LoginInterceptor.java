package com.config.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by LiNan on 2018-05-29.
 * Description:
 */
public class LoginInterceptor implements HandlerInterceptor{


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 校验权限
        String path = request.getServletPath();
        path = path.substring(1, path.length());
        String operaMethod = path.indexOf("/") > 0 ? path.substring(path.lastIndexOf("/")) : path;
        operaMethod = operaMethod.substring(1, operaMethod.length());
        String parameters = getOperaParams(request);
//        String ip = StringUtil.getIp(request);
        // 记日志
//        logOperation(path, ip, parameters);
//        return true;

        System.out.println("-------------1111-----------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 记录文本日志
     * @param path
     * @param parameters
     * @param
     */
    public void logOperation(String path, String ip, String parameters) {
//        String log = "";
//        log = "[OPERALOG]" + "-[" + ip + "]" + "-[" + DateUtil.getSystemTime() + "]-" + "[INFO]-" + path + "-" + parameters;
//        WebLogUtil.infoSys(log);
    }

    /**
     * 获取所有操作参数
     * @param request
     * @return
     */
    private String getOperaParams(HttpServletRequest request) {
        String parameters = "";// 定义所有参数值
        @SuppressWarnings("unchecked")
        Map<String, String[]> map = request.getParameterMap();
        // 取得所有参数值，用&号组装起来
        Object[] obj = null;
        obj = map.keySet().toArray();
        for (int i = 0; i < obj.length; i++) {
            parameters += obj[i].toString() + "=" + request.getParameter(obj[i].toString()) + "&";
        }
        return parameters;
    }
}
