package com.display.service;

import com.display.dao.IndexDao;
import com.update.model.Hanzi;
import com.update.model.Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by LiNan on 2018-05-28.
 * Description:
 */
@Service
public class IndexService {

    @Autowired
    private IndexDao indexDao;

    public Map detail(String hanzi) {
        HashMap<String, String> map= new HashMap<>();
        Hanzi result = indexDao.detail(hanzi);
        if (result != null){
            map.put("pinyin",result.getPinyin());
            map.put("bihua_num",result.getBihua_num());
            map.put("bushou",result.getBushou());
            map.put("jiegou",result.getJiegou());
            map.put("video_url",result.getVideo_url());
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
}
