package com.config.security;

import com.config.util.session.UserSession;
import com.system.service.SysService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by LiNan on 2018-11-22.
 * Description:
 */
public class Realm extends AuthorizingRealm {

    @Autowired
    private SysService sysService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

        //TODO 微信用户需要改造
        String username = token.getUsername();
        String password = new String((char[]) token.getCredentials());
        UserSession userSession = new UserSession();
        Boolean isRight;
        if ("00".equals(username)){
            userSession.setClient_os_info("00");
            //判断是否有权限登录
            isRight = sysService.password(password);
            //判断是否是guest顾客
            if (("000000".equals(password))) {
                userSession.setUsername("guest");
            } else {
                userSession.setUsername(password);
            }
        }else{
            //TODO wx 新建用户表
            isRight = true;
        }

        if (isRight){
            String a = getName();
            AuthenticationInfo info = new SimpleAuthenticationInfo(password,"",getName());
            //将用户信息放入session中
            SecurityUtils.getSubject().getSession().setAttribute("ShiroSession",userSession);

            return info;
        }else{
            return null;
        }
    }

    // 清除缓存,如果需要则添加
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

}
