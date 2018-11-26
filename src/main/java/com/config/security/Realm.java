package com.config.security;

import com.Shiro.service.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by LiNan on 2018-11-22.
 * Description:
 */
public class Realm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        String username = (String)principalCollection.getPrimaryPrincipal();
//        User user = userService.findUserByUserName(username);
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        for(Role role :user.getRoleList()){
//            authorizationInfo.addRole(role.getRoleName());
//            for(Permission permission :role.getPermissionList()){
//                authorizationInfo.addStringPermission(permission.getPermission());
//            }
//        }
//        return authorizationInfo;

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String password = usernamePasswordToken.getUsername();
        Boolean isRight = shiroService.password(password);

        if (isRight){
            AuthenticationInfo info = new SimpleAuthenticationInfo(password,password,getName());
            //将用户信息放入session中
            if ("000000".equals(password)){
                SecurityUtils.getSubject().getSession().setAttribute("ShiroSession","guest");
            }else{
                SecurityUtils.getSubject().getSession().setAttribute("ShiroSession",password);
            }
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
