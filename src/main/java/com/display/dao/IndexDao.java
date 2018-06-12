package com.display.dao;

import com.update.model.Bihua;
import com.update.model.Hanzi;
import com.update.model.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LiNan on 2018-06-05.
 * Description:
 */
@Repository
public class IndexDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Hanzi detail(String hanzi) {
        Object[] params = new Object[]{ hanzi };
        String sql = "select * from fltrp_hanzi where HANZI = ?";
        List<Hanzi> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Hanzi.class));
        return list.size()==0 ? null:list.get(0);
    }

    public List getBihua(String hanzi) {
        Object[] params = new Object[]{ hanzi };
        String sql = "select * from fltrp_relation where HANZI = ? ORDER BY NO";
        List<Relation> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Relation.class));
        return list.size()==0 ? null:list;
    }

    public String getBihuaContent(String bihua_id) {
        Object[] params = new Object[]{ bihua_id };
        String sql = "select * from fltrp_bihua where ID = ?";
        List<Bihua> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Bihua.class));
        String bihua = list.size()==0 ? "":list.get(0).getBihua();
        return bihua;
    }
}
