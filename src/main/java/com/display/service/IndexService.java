package com.display.service;

import com.display.dao.IndexDao;
import com.update.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by LiNan on 2018-05-28.
 * Description:
 */
@Service
public class IndexService {

    @Autowired
    private IndexDao indexDao;

    public Boolean password(String password) {
        String result = indexDao.password(password);
        if ("0".equals(result)){
            return false;
        }else {
            return true;
        }

    }


    public Map detail(String hanzi) {
        HashMap<String, String> map= new HashMap<>();
        Hanzi result = indexDao.detail(hanzi);
        if (result != null){
            map.put("hanzi",result.getHanzi());
            map.put("pinyin",result.getPinyin());
            map.put("bihua_num",result.getBihua_num());
            map.put("bushou",result.getBushou());
            map.put("jiegou",result.getJiegou());
            map.put("video_url",result.getVideo_url());
            map.put("tips",result.getTip());
            map.put("img",result.getImg());
            return map;
        }

        return null;
    }

    public List getBihua(String hanzi) {
        List<Relation> list = indexDao.getBihua(hanzi);
        for (Relation relation: list) {
            String bihua_id = relation.getBihua_id();
            String bihua = indexDao.getBihuaContent(bihua_id);
            relation.setBihua(bihua);
        }
        //排序
        List<Relation> result = new LinkedList<>();
        for (int i = 1;i <= list.size();i++){
            Relation relation = new Relation();
            for (Relation one:list) {
                if (one.getNo().equals(i+"")){
                    relation = one;
                    break;
                }
            }
            result.add(relation);
        }
        return result;
    }

    public Map pinyin(String pinyin) {
        String shengdiao = pinyin.substring(pinyin.length()-1);

        List<PinyinNO> list;

        Map result = new HashMap();

        if ("0".equals(shengdiao)||"1".equals(shengdiao)||"2".equals(shengdiao)||"3".equals(shengdiao)||"4".equals(shengdiao)){
            //带声调
            list = indexDao.duyin(pinyin);
            if(null == list){
                return null;
            }
            if ("0".equals(shengdiao)){
                result.put("0",list);
            }else if ("1".equals(shengdiao)){
                result.put("1",list);
            }else if ("2".equals(shengdiao)){
                result.put("2",list);
            }else if ("3".equals(shengdiao)){
                result.put("3",list);
            }else if ("4".equals(shengdiao)){
                result.put("4",list);
            }
        }else{
            //不带声调
            list = indexDao.qinyin(pinyin);
            List<PinyinNO> duyin0 = new LinkedList();
            List<PinyinNO> duyin1 = new LinkedList();
            List<PinyinNO> duyin2 = new LinkedList();
            List<PinyinNO> duyin3 = new LinkedList();
            List<PinyinNO> duyin4 = new LinkedList();
            if(null == list){
                return null;
            }
            for (PinyinNO qinyin:list) {
                pinyin = qinyin.getPinyin();
                shengdiao = pinyin.substring(pinyin.length()-1);
                if ("0".equals(shengdiao)){
                    duyin0.add(qinyin);
                }else if ("1".equals(shengdiao)){
                    duyin1.add(qinyin);
                }else if ("2".equals(shengdiao)){
                    duyin2.add(qinyin);
                }else if ("3".equals(shengdiao)){
                    duyin3.add(qinyin);
                }else if ("4".equals(shengdiao)){
                    duyin4.add(qinyin);
                }
            }
            result.put("0",duyin0);
            result.put("1",duyin1);
            result.put("2",duyin2);
            result.put("3",duyin3);
            result.put("4",duyin4);

        }

        return result;
    }

    public Map bushouIndex() {
        Map result = new HashMap();
        //按笔画查询
        for (int num=1; num<15; num++){
            List<Bushou> list = indexDao.bushouIndex(String.valueOf(num));
            result.put(String.valueOf(num),list);
        }
        return result;
    }

    public Map bushou(String hanzi) {
        Map result = new HashMap();
        //笔画数
        List<Hanzi> bushouHanzi0 = new LinkedList();
        List<Hanzi> bushouHanzi1 = new LinkedList();
        List<Hanzi> bushouHanzi2 = new LinkedList();
        List<Hanzi> bushouHanzi3 = new LinkedList();
        List<Hanzi> bushouHanzi4 = new LinkedList();
        List<Hanzi> bushouHanzi5 = new LinkedList();
        List<Hanzi> bushouHanzi6 = new LinkedList();
        List<Hanzi> bushouHanzi7 = new LinkedList();
        List<Hanzi> bushouHanzi8 = new LinkedList();
        List<Hanzi> bushouHanzi9 = new LinkedList();
        List<Hanzi> bushouHanzi10 = new LinkedList();
        List<Hanzi> bushouHanzi11 = new LinkedList();
        List<Hanzi> bushouHanzi12 = new LinkedList();
        List<Hanzi> bushouHanzi13 = new LinkedList();
        List<Hanzi> bushouHanzi14 = new LinkedList();
        List<Hanzi> bushouHanzi15 = new LinkedList();
        List<Hanzi> bushouHanzi16 = new LinkedList();
        List<Hanzi> bushouHanzi17 = new LinkedList();
        List<Hanzi> bushouHanzi18 = new LinkedList();
        List<Hanzi> bushouHanzi19 = new LinkedList();
        List<Hanzi> bushouHanzi20 = new LinkedList();
        List<Hanzi> bushouHanzi21 = new LinkedList();
        List<Hanzi> bushouHanzi22 = new LinkedList();
        List<Hanzi> bushouHanzi23 = new LinkedList();
        List<Hanzi> bushouHanzi24 = new LinkedList();
        List<Hanzi> bushouHanzi25 = new LinkedList();
        List<Hanzi> bushouHanzi26 = new LinkedList();
        List<Hanzi> bushouHanzi27 = new LinkedList();
        List<Hanzi> bushouHanzi28 = new LinkedList();
        List<Hanzi> bushouHanzi29 = new LinkedList();
        List<Hanzi> bushouHanzi30 = new LinkedList();
        List<Hanzi> other = new LinkedList();

        List<Hanzi> list = indexDao.bushou(hanzi);
        String bushouNum = indexDao.getBushouNum(hanzi);
        String bushou = indexDao.getBushouImg(hanzi);
        for (Hanzi one : list) {
            String hanziNum = one.getBihua_num();
            int num = Integer.valueOf(hanziNum) - Integer.valueOf(bushouNum);
            if(num == 0){
                bushouHanzi0.add(one);
            }else if (num == 1){
                bushouHanzi1.add(one);
            }else if (num == 2){
                bushouHanzi2.add(one);
            }else if (num == 3){
                bushouHanzi3.add(one);
            }else if (num == 4){
                bushouHanzi4.add(one);
            }else if (num == 5){
                bushouHanzi5.add(one);
            }else if (num == 6){
                bushouHanzi6.add(one);
            }else if (num == 7){
                bushouHanzi7.add(one);
            }else if (num == 8){
                bushouHanzi8.add(one);
            }else if (num == 9){
                bushouHanzi9.add(one);
            }else if (num == 10){
                bushouHanzi10.add(one);
            }else if (num == 11){
                bushouHanzi11.add(one);
            }else if (num == 12){
                bushouHanzi12.add(one);
            }else if (num == 13){
                bushouHanzi13.add(one);
            }else if (num == 14){
                bushouHanzi14.add(one);
            }else if (num == 15){
                bushouHanzi15.add(one);
            }else if (num == 16){
                bushouHanzi16.add(one);
            }else if (num == 17){
                bushouHanzi17.add(one);
            }else if (num == 18){
                bushouHanzi18.add(one);
            }else if (num == 19){
                bushouHanzi19.add(one);
            }else if (num == 20){
                bushouHanzi20.add(one);
            }else if (num == 21){
                bushouHanzi21.add(one);
            }else if (num == 22){
                bushouHanzi22.add(one);
            }else if (num == 23){
                bushouHanzi23.add(one);
            }else if (num == 24){
                bushouHanzi24.add(one);
            }else if (num == 25){
                bushouHanzi25.add(one);
            }else if (num == 26){
                bushouHanzi26.add(one);
            }else if (num == 27){
                bushouHanzi27.add(one);
            }else if (num == 28){
                bushouHanzi28.add(one);
            }else if (num == 29){
                bushouHanzi29.add(one);
            }else if (num == 30){
                bushouHanzi30.add(one);
            }else {
                other.add(one);
            }
        }
        result.put("0",bushouHanzi0);
        result.put("1",bushouHanzi1);
        result.put("2",bushouHanzi2);
        result.put("3",bushouHanzi3);
        result.put("4",bushouHanzi4);
        result.put("5",bushouHanzi5);
        result.put("6",bushouHanzi6);
        result.put("7",bushouHanzi7);
        result.put("8",bushouHanzi8);
        result.put("9",bushouHanzi9);
        result.put("10",bushouHanzi10);
        result.put("11",bushouHanzi11);
        result.put("12",bushouHanzi12);
        result.put("13",bushouHanzi13);
        result.put("14",bushouHanzi14);
        result.put("15",bushouHanzi15);
        result.put("16",bushouHanzi16);
        result.put("17",bushouHanzi17);
        result.put("18",bushouHanzi18);
        result.put("19",bushouHanzi19);
        result.put("20",bushouHanzi20);
        result.put("21",bushouHanzi21);
        result.put("22",bushouHanzi22);
        result.put("23",bushouHanzi23);
        result.put("24",bushouHanzi24);
        result.put("25",bushouHanzi25);
        result.put("26",bushouHanzi26);
        result.put("27",bushouHanzi27);
        result.put("28",bushouHanzi28);
        result.put("29",bushouHanzi29);
        result.put("30",bushouHanzi30);
        result.put("other",other);
        result.put("bushou",bushou);
        return result;
    }


}
