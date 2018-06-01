package com.update.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by LiNan on 2018-05-31.
 * Description:
 */
@Repository
public class UpdateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void jiaru() {
        String sql = "insert into FLTRP_HANZI (ID, NUM, HANZI) VALUE ('0','0','测试')";
        jdbcTemplate.execute(sql);
    }
}
