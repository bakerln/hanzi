package com.update.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiNan on 2018-06-01.
 * Description:
 */
@Service
public class UploadService {


    public void json(HashMap<String, HashMap> hanzi_jsonMap) {
        for(Map.Entry<String, HashMap> entry : hanzi_jsonMap.entrySet()){

            String key = entry.getKey();
            HashMap a = entry.getValue();

        }
        System.out.println(hanzi_jsonMap);
    }
}
