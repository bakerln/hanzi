package com.config.security;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by LiNan on 2018-11-22.
 * Description: 密码验证规则重写
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher  {

//    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
//
//        try {
//            UsernamePasswordToken usertoken = (UsernamePasswordToken) token;
//            String password = String.valueOf(usertoken.getPassword());
//            //我这里使用的md5加密，自己写的类MD5Utils,里面进行密码加密
//            Object tokenCredentials = MD5Utils.encryptPassword(password);
//            Object accountCredentials =getCredentials(info);
//            return equals(tokenCredentials,accountCredentials);
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }


}
