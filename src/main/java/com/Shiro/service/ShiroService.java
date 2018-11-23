package com.Shiro.service;

import com.Shiro.dao.ShiroDao;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by LiNan on 2018-11-22.
 * Description:
 */

@Service
public class ShiroService {

    @Autowired
    private ShiroDao shiroDao;

    public Boolean password(String password) {
        String result = shiroDao.password(password);
        if ("0".equals(result)) {
            return false;
        } else {
            return true;
        }

    }

    public void login(String password) throws Exception {
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
//            if (null != currentUser.getPrincipal()){
//                password = (String)currentUser.getPrincipal();
//            }
            UsernamePasswordToken token = new UsernamePasswordToken(password, password);
//            token.setRememberMe(true);//是否记住用户
            try {
                currentUser.login(token);//执行登录
            } catch (UnknownAccountException uae) {
                throw new Exception("账户不存在");
            } catch (IncorrectCredentialsException ice) {
                throw new Exception("密码不正确");
            } catch (LockedAccountException lae) {
                throw new Exception("用户被锁定了 ");
            } catch (AuthenticationException ae) {
                ae.printStackTrace();
                throw new Exception("未知错误");
            }
        }

    }
}
