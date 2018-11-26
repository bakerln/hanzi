package com.Shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by LiNan on 2018-11-22.
 * Description:
 */
public class ShiroTest {
    private static Logger logger = LoggerFactory.getLogger("testLog");

    public static void main(String[] args) {
        IniSecurityManagerFactory factory =
                new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();

        //测试在应用的当前会话中设置属性
        Session session = currentUser.getSession();

        session.setAttribute("someKey","aValue");

        String value = (String) session.getAttribute("someKey");

        if ("aValue".equals(value)){
            logger.info("检索到正确的值【" + value + "】");
        }
        //尝试进行登录用户，如果登录失败了，进行一些处理
        if (!currentUser.isAuthenticated()){
            //未登录
            UsernamePasswordToken token = new UsernamePasswordToken("test","12345");
            token.setRememberMe(true);
            try{
                currentUser.login(token);
                logger.info("用户【" + currentUser.getPrincipal() + "】登录成功");
                //查看用户是否有指定的角色
                if (currentUser.hasRole("admin")){
                    logger.info("您有admin ");
                }else{
                    logger.info("您没有admin");
                }
                if (currentUser.hasRole("role1")){
                    logger.info("have role1 ");
                }else{
                    logger.info("do not have role1");
                }
                //查看用户是否有某个权限
                if (currentUser.isPermitted("perm1")){
                    logger.info("have perm1");
                }else{
                    logger.info("do not have perm1");
                }
                if (currentUser.isPermitted("guest")){
                    logger.info("have guest");
                }else{
                    logger.info("do not have guest");
                }
                //登出
                currentUser.logout();
            }catch (UnknownAccountException uae){
                logger.info(token.getPrincipal() + "not exist");
            }catch (IncorrectCredentialsException ice){
                logger.info(token.getPrincipal() + " not correct");
            }catch(LockedAccountException lae){
                logger.info(token.getPrincipal() + "had been locked");
            }catch(AuthenticationException ae){
                logger.info(ae.getMessage());
            }
        }
    }
}
