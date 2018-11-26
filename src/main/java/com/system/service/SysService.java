package com.system.service;

import com.system.dao.SysDao;
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
}
