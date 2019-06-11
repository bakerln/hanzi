package com.system.dao;

import com.update.model.Relation;
import com.update.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public User hasUser(String username) {
        Object[] params = new Object[]{username};
        String sql = "select * from fltrp_user where username = ?";
        List<User> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(User.class));
        return list.size()==0 ? null:list.get(0);
    }

    public int createUser(User user) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "insert into fltrp_user (USERNAME,TYPE,NUM,CREATEDATE,STATUS,CODE) values (:username,:type,:num,now(),:status,:code)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }


    public int updateUser(User user) {
        String sql = "update fltrp_user set TYPE=:type,CODE=:code where USERNAME=:username";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(user);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }
}
