package com.config.security;

import com.config.util.session.UserSession;
import com.system.service.SysService;
import com.update.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


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

        String username = token.getUsername();
        String password = new String((char[]) token.getCredentials());
        UserSession userSession = new UserSession();
        Boolean isRight;
        //pc
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
            if (isRight){
                AuthenticationInfo info = new SimpleAuthenticationInfo(password,password,getName());
                //将用户信息放入session中
                SecurityUtils.getSubject().getSession().setAttribute("userSession",userSession);
                return info;
            }else{
                return null;
            }


        }else{    //wx

            isRight = sysService.password(password);

            User hasUser = sysService.hasUser(username);

            if (hasUser == null){
                //新增用户
                hasUser = new User();
                hasUser.setUsername(username);
                hasUser.setNum(5);
                hasUser.setCreateDate(new Date());
                hasUser.setStatus("00");
                if (isRight){
                    hasUser.setType("02");
                    hasUser.setCode(password);
                }else {
                    hasUser.setType("01");
                }
                sysService.createUser(hasUser);
            }else if ("01".equals(hasUser.getType()) && isRight){
                hasUser = new User();
                hasUser.setUsername(username);
                hasUser.setType("02");
                hasUser.setCode(password);
                sysService.updateUser(hasUser);
            }
            AuthenticationInfo info = new SimpleAuthenticationInfo(password,password,getName());
            SecurityUtils.getSubject().getSession().setAttribute("wxSession",hasUser);
            return info;
        }


    }

    // 清除缓存,如果需要则添加
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

}
