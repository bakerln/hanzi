package com.Shiro.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by LiNan on 2018-11-22.
 * Description:
 */
@Repository
public class ShiroDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String password(String password) {
        Object[] params = new Object[]{password};
        String sql = "select count(*) from fltrp_password where PWD = ?";
        return jdbcTemplate.queryForObject(sql, params,String.class);
    }
}
