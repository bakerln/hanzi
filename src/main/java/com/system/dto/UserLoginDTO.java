package com.system.dto;

/**
 * Created by LiNan on 2018-07-16.
 * Description:
 */
public class UserLoginDTO {
    private String username;
    private String password;
    private String ip;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
