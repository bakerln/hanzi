package com.config.util.session;


/**
 * Created by LiNan on 2018-01-09.
 * Description:  系统用户Session信息
 */
public class UserSession{
    private String username;//用户名
    private String password;// 登录密码
    private String randomCode;// 随机数
    private String userIp;// 用户IP
    private String client_os_info;
    private String client_browser_info;
    private String client_browser_version;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRandomCode() {
        return randomCode;
    }

    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getClient_os_info() {
        return client_os_info;
    }

    public void setClient_os_info(String client_os_info) {
        this.client_os_info = client_os_info;
    }

    public String getClient_browser_info() {
        return client_browser_info;
    }

    public void setClient_browser_info(String client_browser_info) {
        this.client_browser_info = client_browser_info;
    }

    public String getClient_browser_version() {
        return client_browser_version;
    }

    public void setClient_browser_version(String client_browser_version) {
        this.client_browser_version = client_browser_version;
    }
}
