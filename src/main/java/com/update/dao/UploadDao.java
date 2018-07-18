package com.update.dao;

import com.update.model.*;
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

    public void excelPinyin(Pinyin pinyin) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "UPDATE  fltrp_pinyin set DUYIN_1=:duyin_1,DUYIN_2=:duyin_2,DUYIN_3=:duyin_3,DUYIN_4=:duyin_4,DUYIN_5=:duyin_5," +
                "QINYIN_1=:qinyin_1,QINYIN_2=:qinyin_2,QINYIN_3=:qinyin_3 WHERE HANZI = :hanzi";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(pinyin);
        int a = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
        System.out.println(pinyin.getHanzi()+"        "+ a);
    }

    public void wordHanzi(Hanzi hanzi) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "UPDATE fltrp_hanzi set TIP = :tip WHERE HANZI = :hanzi";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(hanzi);
        int a = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
        System.out.println(hanzi.getHanzi()+"        "+ a);
    }

    public List hanziIDList() {
        String sql = "select ID,HANZI from fltrp_hanzi";
        return jdbcTemplate.queryForList(sql);
    }


    public void input(String id, String hanzi) {
        String sql = "insert into fltrp_pinyin (ID, HANZI) value ('"+id+"','"+hanzi+"')";
        jdbcTemplate.execute(sql);
    }

    public void test(String name) {
        String sql = "insert into fltrp_test (ID,NAME) values (2,'"+ name +"')";
        jdbcTemplate.execute(sql);
        System.out.println(name);
    }


    public void excelBUSHOU(Hanzi hanzi) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "UPDATE fltrp_hanzi set bushou = :bushou WHERE HANZI = :hanzi";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(hanzi);
        int a = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
        System.out.println("更新汉字表"+hanzi.getHanzi()+"        "+ a);
    }

    public void excelBUSHOU2(Bushou bushouModel) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "insert into fltrp_bushou (ID,BUSHOU,NUM) values (:id,:bushou,:num)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(bushouModel);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
        System.out.println(bushouModel.getBushou()+"        "+ bushouModel.getNum());
    }

    public void excelDuoKaiMen(Hanzi one) {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        String sql = "UPDATE fltrp_hanzi set bushou_1 = :bushou_1, bushou_2 = :bushou_2 WHERE HANZI = :hanzi";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(one);
        int a = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
        System.out.println(one.getHanzi());
    }

//    public void addPassword(Password password) {
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
//        String sql = "insert into fltrp_password (ID,PWD) values (:id,:password)";
//        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(password);
//        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
//        System.out.println(password.getPassword()+"        "+ password.getId());
//    }

    public List getPassword() {
        String sql = "select * from fltrp_password";
        return jdbcTemplate.queryForList(sql);
    }
}
