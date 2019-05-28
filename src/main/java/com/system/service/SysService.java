package com.system.service;

import com.system.dao.SysDao;
import com.system.dto.UserLoginDTO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by linan on 2018-11-26.
 * Description:
 */

@Service
public class SysService {

    @Autowired
    private SysDao sysDao;

    public Boolean password(String password) {
        String result = sysDao.password(password);
        if ("0".equals(result)) {
            return false;
        } else {
            return true;
        }

    }

    public void login(UserLoginDTO userLogin) throws Exception {
        Subject currentUser = SecurityUtils.getSubject();

        String userName;
        String password = userLogin.getPassword();

        if ("00".equals(userLogin.getClient_os_info())){
            //PC,传入“00”后台逻辑识别
            userName = userLogin.getClient_os_info();
        }else{
            //微信
            userName = userLogin.getUsername();
        }

        if (!currentUser.isAuthenticated()) {
            if (null != currentUser.getPrincipal()){
                password = (String)currentUser.getPrincipal();
            }
            UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
            token.setRememberMe(true);//是否记住用户
            try {
                currentUser.login(token);//执行登录
            } catch (UnknownAccountException uae) {
                throw new IncorrectCredentialsException("账户不存在");
            } catch (IncorrectCredentialsException ice) {
                throw new IncorrectCredentialsException("密码不正确");
            } catch (LockedAccountException lae) {
                throw new IncorrectCredentialsException("用户被锁定了 ");
            } catch (AuthenticationException ae) {
                ae.printStackTrace();
                throw new IncorrectCredentialsException("未知错误");
            }
        }
    }
}
