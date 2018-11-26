package com.system.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by linan on 2018-11-26.
 * Description:
 */

@Repository
public class SysDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String password(String password) {
        Object[] params = new Object[]{password};
        String sql = "select count(*) from fltrp_password where PWD = ?";
        return jdbcTemplate.queryForObject(sql, params,String.class);
    }
}
