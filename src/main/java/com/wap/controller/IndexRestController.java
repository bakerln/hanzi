package com.wap.controller;

import com.config.util.global.GlobalCode;
import com.config.util.json.JsonMsg;
import com.web.service.IndexService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by linan on 2019-04-24
 * Description:
 */
@RestController
@RequestMapping(value = "/wap")
public class IndexRestController {
    private static Logger logger = LoggerFactory.getLogger("operationLog");

    @Autowired
    private IndexService indexService;

    /**
     * 汉字查询 (详细页面)
     * @param hanzi
     * @return
     */
    @GetMapping(value = "/detail/{hanzi}")
    public JsonMsg detail(@PathVariable String hanzi){
//        Session session = SecurityUtils.getSubject().getSession();
//        logger.info("Session : " + session.getAttribute("ShiroSession").toString() + "正在进行汉字查询");
        Map result = indexService.detail(hanzi);
        if (result == null){
            return new JsonMsg(true,"获取汉字详情", GlobalCode.FAIL,null);
        }
        //获得笔画
        List list = indexService.getBihua((String)result.get("hanzi"));
        result.put("bihua",list);
        return new JsonMsg(true,"获取汉字详情", GlobalCode.SUCCESS,result);
    }

    /**
     * 拼音查询
     * @param pinyin
     * @return
     */
    @GetMapping(value = "/pinyin/{pinyin}")
    public JsonMsg pinyin(@PathVariable String pinyin){
//        Session session = SecurityUtils.getSubject().getSession();
//        logger.info("Session : " + session.getAttribute("ShiroSession").toString() + "正在进行拼音查询");
        Map result = indexService.pinyin(pinyin);
        if (result == null){
            return new JsonMsg(true,"获取拼音详情", GlobalCode.FAIL,null);
        }
        result.put("bihua",pinyin);
        return new JsonMsg(true,"获取拼音详情", GlobalCode.SUCCESS,result);
    }

    /**
     * 部首查询页
     * @return
     */
    @GetMapping(value = "/bushouIndex")
    public JsonMsg bushouIndex(){
//        Session session = SecurityUtils.getSubject().getSession();
//        logger.info("Session : " + session.getAttribute("ShiroSession").toString() + "正在进行部首查询");
        Map result = indexService.bushouIndex();
        return new JsonMsg(true,"获取笔画索引", GlobalCode.SUCCESS,result);

    }



    /**
     * 部首所属汉字
     @param bushou :部首ID
     */
    @GetMapping(value = "/bushou/{bushou}")
    public JsonMsg bushou(@PathVariable String bushou){
//        Session session = SecurityUtils.getSubject().getSession();
        Map result = indexService.bushou(bushou);
        return new JsonMsg(true,"获取笔画索引", GlobalCode.SUCCESS,result);
    }
}
