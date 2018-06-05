package com.update.service;

import com.config.util.excel.ExcelUtil;
import com.config.util.excel.WordUtil;
import com.update.dao.UploadDao;
import com.update.model.Bihua;
import com.update.model.Jiegou;
import com.update.model.Hanzi;
import com.update.model.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
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
                relation.setNo(no+"");
                String xuhao = "";
                if (no < 10){
                    xuhao = "0"+ no;
                }else xuhao = no + "";
                String bihuaUrl = hanzi.getId() + hanzi.getHanzi()+"/"+ xuhao + ".png";
                relation.setUrl(bihuaUrl);
                uploadDao.excelRelation(relation);
            }
        }
    }

    public void wordHANZI(String name, CommonsMultipartFile file) {
        ArrayList<String> content = (ArrayList) wordUtil.getWordTips(name,file);
        for (String one:content) {
            String[] list = one.split("：");
            Hanzi hanzi = new Hanzi();
            hanzi.setHanzi(list[0]);

            hanzi.setTip(list[1]);
//            uploadDao.wordHanzi(hanzi);
        }
    }
}
