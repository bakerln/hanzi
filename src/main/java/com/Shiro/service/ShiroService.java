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


}
