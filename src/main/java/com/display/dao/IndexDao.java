package com.display.dao;

import com.update.model.*;
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
        String sql = "select * from fltrp_hanzi a,fltrp_bushou b where a.hanzi = ? and a.bushou = b.bushou";
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

//    public List<Pinyin> pinyin(String pinyin) {
//        Object[] params = new Object[]{ pinyin,pinyin,pinyin,pinyin,pinyin,pinyin,pinyin,pinyin };
//        String sql = "select * from fltrp_pinyin where DUYIN_1= ? OR DUYIN_2= ? OR DUYIN_3= ? OR DUYIN_4= ? OR DUYIN_5= ? " +
//                "OR QINYIN_1= ? OR QINYIN_2= ? OR QINYIN_3= ?";
//        List<Pinyin> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Pinyin.class));
//        return list.size()==0 ? null:list;
//    }

    public List<Pinyin> duyin(String pinyin) {
        Object[] params = new Object[]{ pinyin,pinyin,pinyin,pinyin,pinyin};
        String sql = "select * from fltrp_pinyin where DUYIN_1= ? OR DUYIN_2= ? OR DUYIN_3= ? OR DUYIN_4= ? OR DUYIN_5= ? ";
        List<Pinyin> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Pinyin.class));
        return list.size()==0 ? null:list;
    }

    public List<Pinyin> qinyin(String pinyin) {
        Object[] params = new Object[]{pinyin,pinyin,pinyin};
        String sql = "select * from fltrp_pinyin where QINYIN_1= ? OR QINYIN_2= ? OR QINYIN_3= ?";
        List<Pinyin> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Pinyin.class));
        return list.size()==0 ? null:list;
    }

    public List<Bushou> bushouIndex(String num) {
        Object[] params = new Object[]{num};
        String sql = "select * from fltrp_bushou where NUM = ? ";
        List<Bushou> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Bushou.class));
        return list.size()==0 ? null:list;
    }

    public List<Hanzi> bushou(String bushou) {
        Object[] params = new Object[]{bushou};
        String sql = "select * from fltrp_hanzi a,fltrp_bushou b where b.id = ? and  b.bushou in( a.bushou, a.bushou_1,a.bushou_2)";
        List<Hanzi> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Hanzi.class));
        System.out.println(list);
        return list.size()==0 ? null:list;
    }

    public String getBushouNum(String hanzi) {
        Object[] params = new Object[]{hanzi};
        String sql = "select NUM from fltrp_bushou where ID = ? ";
        return jdbcTemplate.queryForObject(sql,params,String.class);
    }

    public String getBushouImg(String hanzi) {
        Object[] params = new Object[]{hanzi};
        String sql = "select IMG from fltrp_bushou where ID = ? ";
        return jdbcTemplate.queryForObject(sql,params,String.class);
    }

    public String password(String password) {
        Object[] params = new Object[]{password};
        String sql = "select count(*) from fltrp_password where PWD = ?";
        return jdbcTemplate.queryForObject(sql, params,String.class);
    }
}
