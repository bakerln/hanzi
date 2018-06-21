package com.update.dao;

import com.update.model.Bihua;
import com.update.model.Jiegou;
import com.update.model.Hanzi;
import com.update.model.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LiNan on 2018-06-04.
 * Description:
 */
@Repository
public class UploadDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int json(Hanzi jsonHanzi) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "UPDATE fltrp_hanzi set PINYIN = :pinyin,BIHUA_NUM = :bihua_num,BUSHOU = :bushou WHERE HANZI = :hanzi";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(jsonHanzi);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    public int excelJiegou(Jiegou jiegou) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "insert into fltrp_jiegou (ID,JIEGOU) values (:id,:jiegou)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(jiegou);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    public int excelBihua(Bihua bihua) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "insert into fltrp_bihua (ID,BIHUA) values (:id,:bihua)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(bihua);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    public int excelHanzi(Hanzi hanzi) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "insert into fltrp_hanzi (ID,NUM,HANZI,JIEGOU,VIDEO_URL) values (:id,:num,:hanzi,:jiegou,:video_url)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(hanzi);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    public int excelRelation(Relation relation) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "insert into fltrp_relation (ID,HANZI_ID,HANZI,BIHUA_ID,NO,URL) values (:id,:hanzi_id,:hanzi,:bihua_id,:no,:url)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(relation);
        return namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    public void wordHanzi(Hanzi hanzi) {

        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "UPDATE fltrp_hanzi set TIP = :tip WHERE HANZI = :hanzi";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(hanzi);
        int a = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
        System.out.println(hanzi.getHanzi()+"        "+ a);
    }

    public void test(String name) {
        String sql = "insert into fltrp_test (ID,NAME) values (1,'"+ name +"')";
        jdbcTemplate.execute(sql);
    }
}
