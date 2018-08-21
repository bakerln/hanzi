package com.update.service;

import com.config.util.excel.ExcelUtil;
import com.config.util.excel.WordUtil;
import com.config.util.string.Md5SaltUtil;
import com.config.util.string.StringUtil;
import com.config.util.web.WebUtil;
import com.update.dao.UploadDao;
import com.update.model.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

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
//            uploadDao.excelBUSHOU(hanzi);
            String num = one.getNum();
            num = num.substring(0,num.length()-2);
            bushou.put(one.getBushou(),num);
        }
//        System.out.println(bushou);
//        for (String key:bushou.keySet()) {
//            Bushou bushouModel = new Bushou();
//            bushouModel.setId(String.valueOf(a));
//            bushouModel.setBushou(key);
//            bushouModel.setNum(bushou.get(key));
//            uploadDao.excelBUSHOU2(bushouModel);
//            a++;
//        }
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


    public void getPassword(HttpServletResponse response,int num) {
//        List<String> result = new LinkedList<>();
//        for (int i = 1;i<=num;i++){
//            Password pwd = new Password();
//            String salt = StringUtil.createRandomCode(8);
//            Md5SaltUtil encoderMd5 = new Md5SaltUtil(salt, "MD5");
//            String password = encoderMd5.encode(String.valueOf(i)).substring(0,6);
//            pwd.setPassword(password);
//            pwd.setId(String.valueOf(i));
//            uploadDao.addPassword(pwd);
//            result.add(password);
//        }
        List<Map> result = uploadDao.getPassword();

        List<Map> result1 = result.subList(0,49999);
        List<Map> result2 = result.subList(50000,99999);

        //导出excel_1
        String[][] data1 = new String[result1.size()][2];
        for (int i = 0; i < result1.size(); i++) {
            Map map = result1.get(i);
            data1[i][0] = StringUtil.getSafeStr(map.get("ID"));
            data1[i][1] = StringUtil.getSafeStr(map.get("PWD"));
        }
        HSSFWorkbook wb_1 = ExcelUtil.out(data1,"password_1");
        WebUtil.outExcel(response,wb_1,"password_1");
        //导出excel_2
        String[][] data2 = new String[result2.size()][2];
        for (int i = 0; i < result2.size(); i++) {
            Map map = result2.get(i);
            data2[i][0] = StringUtil.getSafeStr(map.get("ID"));
            data2[i][1] = StringUtil.getSafeStr(map.get("PWD"));
        }
        HSSFWorkbook wb_2 = ExcelUtil.out(data2,"password_2");
        WebUtil.outExcel(response,wb_2,"password_2");
    }


    @Transactional
    public void geshi() {
        List list = uploadDao.geshi();
        for (Object o: list) {
            Map map = (Map) o;
            String pinyin = (String)map.get("PINYIN");
            String new_pinyin = "";
            Hanzi hanzi = new Hanzi();
            if (pinyin.split(" ").length > 1){
                String[] ones = pinyin.split(" ");
                for (String one: ones) {
                    if (new_pinyin.equals("")){
                        new_pinyin = new_pinyin + one;
                    }else{
                        new_pinyin = new_pinyin + ";" +  one;
                    }
                }
                hanzi.setPinyin(new_pinyin);
                hanzi.setHanzi((String)map.get("HANZI"));
                uploadDao.updateGeshi(hanzi);
            }
        }
    }

    @Transactional
    public void excelBUSHOU_NO(String name, CommonsMultipartFile file) {
        ArrayList<BushouNO> content = (ArrayList) excelUtil.getExcelBushouNo(name,file);
        int length = content.size();
        for(int i = 0;i < length; i++){
            BushouNO one = content.get(i);
            String num = one.getNo();
            num = num.substring(0,num.length()-2);
            one.setNo(num);
            //判断是否重复
            if (i == 0){
                uploadDao.excelBUSHOU_NO(one);
            }else{
                BushouNO one_before = content.get(i-1);
                if (!one.getHanzi().equals(one_before.getHanzi())||!one.getBushou().equals(one_before.getBushou())){
                    uploadDao.excelBUSHOU_NO(one);
                }else{
                    System.out.println("------------------------------------------");
                    System.out.println(one.getHanzi());
                }
            }
        }
    }


    @Transactional
    public void excelPINYIN_NO(String name, CommonsMultipartFile file) {
        ArrayList<PinyinNO> content = (ArrayList) excelUtil.getExcelPINYINNo(name,file);

        for (PinyinNO one: content) {
            String num = one.getNo();
            num = num.substring(0,num.length()-2);
            one.setNo(num);
            uploadDao.excelPinyinNO(one);
        }
    }
}
