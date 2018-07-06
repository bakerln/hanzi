package com.update.service;

import com.config.util.excel.ExcelUtil;
import com.config.util.excel.WordUtil;
import com.update.dao.UploadDao;
import com.update.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiNan on 2018-06-01.
 * Description:
 */
@Service
public class UploadService {

    @Autowired
    private UploadDao uploadDao;

    @Autowired
    private ExcelUtil excelUtil;

    @Autowired
    private WordUtil wordUtil;

    @Transactional
    public void json(HashMap<String, HashMap> hanzi_jsonMap) {
        for(Map.Entry<String, HashMap> entry : hanzi_jsonMap.entrySet()){

            Hanzi jsonHanzi = new Hanzi();
            String hanzi = entry.getKey();//汉字
            HashMap content = entry.getValue();

            jsonHanzi.setHanzi(hanzi);
            jsonHanzi.setPinyin((String)content.get("duyin"));
            jsonHanzi.setBihua_num((String)content.get("bihua"));
            jsonHanzi.setBushou((String)content.get("bushou"));

            uploadDao.json(jsonHanzi);

        }
        System.out.println(hanzi_jsonMap);
    }

    @Transactional
    public void excelBIHUA(String name, CommonsMultipartFile file) {

        HashMap content = (HashMap) excelUtil.getExcelBIHUAInfo(name,file);

        ArrayList<String> bihuaList = (ArrayList) content.get("bihuaList");
        ArrayList<String> jiegouList = (ArrayList) content.get("jiegouList");

        //导入结构数据
        for (String string:jiegouList) {
            String[] a = string.split(" ");
            Jiegou jiegou = new Jiegou();
            jiegou.setId(a[0]);
            jiegou.setJiegou(a[1]);

            uploadDao.excelJiegou(jiegou);
        }
        //导入笔画数据
        for (String string:bihuaList) {
            String[] a = string.split(": ");
            Bihua bihua = new Bihua();
            bihua.setId(a[0]);
            bihua.setBihua(a[1]);

            uploadDao.excelBihua(bihua);
        }

        System.out.println(content);
    }

    @Transactional
    public void excelHANZI(String name, CommonsMultipartFile file) {
        ArrayList<Hanzi> content = (ArrayList) excelUtil.getExcelHANZIInfo(name,file);

        //导入汉字数据
        for (Hanzi hanzi:content) {
            String jiegou = hanzi.getJiegou();
            if ("1.0".equals(jiegou)){
                hanzi.setJiegou("左右");
            }else if ("2.0".equals(jiegou)){
                hanzi.setJiegou("上下");
            }else if ("3.0".equals(jiegou)){
                hanzi.setJiegou("左右左");
            }else if ("4.0".equals(jiegou)){
                hanzi.setJiegou("上中下");
            }else if ("5.0".equals(jiegou)){
                hanzi.setJiegou("独体");
            }else if ("6.0".equals(jiegou)){
                hanzi.setJiegou("半包围");
            }else if ("7.0".equals(jiegou)){
                hanzi.setJiegou("全包围");
            }
            String url = hanzi.getId() + hanzi.getHanzi() + ".mp4";
            hanzi.setVideo_url(url);
            uploadDao.excelHanzi(hanzi);
            //导入关系数据
            String bihua = hanzi.getBihua();
            String[] list = bihua.split("");
            for(int i = 0 ; i<list.length ;i++){
                Relation relation = new Relation();
                int no = i+1;
                String id = hanzi.getId() + "_" + no;
                relation.setId(id);
                relation.setHanzi_id(hanzi.getId());
                relation.setHanzi(hanzi.getHanzi());
                relation.setBihua_id(list[i]);
                relation.setNo(String.valueOf(no));
                String xuhao;
                if (no < 10){
                    xuhao = "0"+ no;
                }else xuhao = no + "";
                String bihuaUrl = hanzi.getId() + hanzi.getHanzi()+"/"+ xuhao + ".png";
                relation.setUrl(bihuaUrl);
                uploadDao.excelRelation(relation);
            }
        }
    }

    @Transactional
    public void excelPINYIN(String name, CommonsMultipartFile file) {
        ArrayList<Pinyin> content = (ArrayList) excelUtil.getExcelPINYINInfo(name,file);
        for (Pinyin pinyin:content) {
            String duyin = pinyin.getDuyin_1();
            String[] duyinList = duyin.split(";");
            if (1 == duyinList.length){
                pinyin.setDuyin_1(duyinList[0]);
            }else if (2 == duyinList.length){
                pinyin.setDuyin_1(duyinList[0]);
                pinyin.setDuyin_2(duyinList[1]);
            }else if (3 == duyinList.length){
                pinyin.setDuyin_1(duyinList[0]);
                pinyin.setDuyin_2(duyinList[1]);
                pinyin.setDuyin_3(duyinList[2]);
            }else if (4 == duyinList.length){
                pinyin.setDuyin_1(duyinList[0]);
                pinyin.setDuyin_2(duyinList[1]);
                pinyin.setDuyin_3(duyinList[2]);
                pinyin.setDuyin_4(duyinList[3]);
            }else if (5 == duyinList.length){
                pinyin.setDuyin_1(duyinList[0]);
                pinyin.setDuyin_2(duyinList[1]);
                pinyin.setDuyin_3(duyinList[2]);
                pinyin.setDuyin_4(duyinList[3]);
                pinyin.setDuyin_5(duyinList[4]);
            }
            String qinyin = pinyin.getQinyin_1();
            String[] qinyinList = qinyin.split(";");
            if (1 == qinyinList.length){
                pinyin.setQinyin_1(qinyinList[0]);
            }else if (2 == qinyinList.length){
                pinyin.setQinyin_1(qinyinList[0]);
                pinyin.setQinyin_2(qinyinList[1]);
            }else if (3 == qinyinList.length){
                pinyin.setQinyin_1(qinyinList[0]);
                pinyin.setQinyin_2(qinyinList[1]);
                pinyin.setQinyin_3(qinyinList[2]);
            }
            uploadDao.excelPinyin(pinyin);
        }
    }

    @Transactional
    public void excelBUSHOU(String name, CommonsMultipartFile file) {
        ArrayList<Bushou> content = (ArrayList) excelUtil.getExcelBushouInfo(name,file);

        int a = 1;
        Map<String,String> bushou = new HashMap();
        //去重
        for (Bushou one:content) {
            //更新汉字表
            Hanzi hanzi = new Hanzi();
            hanzi.setHanzi(one.getHanzi());
            hanzi.setBushou(one.getBushou());
            uploadDao.excelBUSHOU(hanzi);
            String num = one.getNum();
            num = num.substring(0,num.length()-2);
            bushou.put(one.getBushou(),num);
        }
        for (String key:bushou.keySet()) {
            Bushou bushouModel = new Bushou();
            bushouModel.setId(String.valueOf(a));
            bushouModel.setBushou(key);
            bushouModel.setNum(bushou.get(key));
            uploadDao.excelBUSHOU2(bushouModel);
            a++;
        }
    }
    @Transactional
    public void excelDUOKAIMEN(String name, CommonsMultipartFile file) {
        ArrayList<Hanzi> content = (ArrayList) excelUtil.getExcelDuoKaiMenInfo(name,file);
        for (Hanzi one : content) {
            String bushou = one.getBushou();
            String[] bushoulist = bushou.split(";");
            if (bushoulist.length==1){
                one.setBushou_1(bushoulist[0]);
            } else{
                one.setBushou_1(bushoulist[0]);
                one.setBushou_2(bushoulist[1]);
            }
            uploadDao.excelDuoKaiMen(one);
        }
    }


    @Transactional
    public void wordHANZI(String name, CommonsMultipartFile file) {
        ArrayList<String> content = (ArrayList) wordUtil.getWordTips(name,file);
        for (String one:content) {
            String[] list = one.split("：");
            Hanzi hanzi = new Hanzi();
            hanzi.setHanzi(list[0]);

            hanzi.setTip(list[1]);
            uploadDao.wordHanzi(hanzi);
        }
    }

    @Transactional
    public void test(String name) {
        for(int a = 1; a<5;a++){
            uploadDao.test(name);
        }

    }

    public List hanziIDList() {
        return uploadDao.hanziIDList();
    }

    @Transactional
    public void input(List list) {
        for (Object hanziObject:list) {
            Map one = (Map) hanziObject;
            String id = (String) one.get("ID");
            String hanzi = (String) one.get("hanzi");
            uploadDao.input(id,hanzi);

        }
    }



}
