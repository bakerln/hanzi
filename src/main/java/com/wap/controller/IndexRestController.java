package com.wap.controller;

import com.config.util.global.GlobalCode;
import com.config.util.json.JsonMsg;
import com.update.model.User;
import com.web.service.IndexService;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
     * @param request
     * @return
     */
    @GetMapping(value = "/detail")
    public JsonMsg detail(HttpServletRequest request,String hanzi){
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("wxSession");
        if (user == null){
            return new JsonMsg(true,"请重新登录",GlobalCode.FAIL,null);
        }
        //试用用户
        if (user.getType().equals("01")){
            int times = (int)request.getSession().getAttribute("times");
            if (times == 0){
                return new JsonMsg(true,"今日汉字查询次数已满",GlobalCode.FAIL,null);
            }else {
                times--;
                request.getSession().setAttribute("times",times);
            }
        }

        logger.info(new Date() + "  user : " + user.getUsername() +
                " 使用 wx 进行汉字查询");

        Map result = indexService.detail(hanzi);
        if (result == null){
            return new JsonMsg(true,"此汉字无数据", GlobalCode.FAIL,null);
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
    @GetMapping(value = "/pinyin")
    public JsonMsg pinyin(HttpServletRequest request,String pinyin){

        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("wxSession");
        if (user == null){
            return new JsonMsg(true,"请重新登录",GlobalCode.FAIL,null);
        }
        //试用用户
        if (user.getType().equals("01")){
            int times = (int)request.getSession().getAttribute("times");
            if (times == 0){
                return new JsonMsg(true,"今日查询次数已满",GlobalCode.FAIL,null);
            }else {
                times--;
                request.getSession().setAttribute("times",times);
            }
        }

        logger.info(new Date() + "  user : " + user.getUsername() +
                " 使用 wx 进行拼音查询");

        Map result = indexService.pinyin(pinyin);
        if (result == null){
            return new JsonMsg(true,"此拼音无数据", GlobalCode.FAIL,null);
        }
        result.put("bihua",pinyin);
        return new JsonMsg(true,"获取拼音详情", GlobalCode.SUCCESS,result);
    }

    /**
     * 部首查询页
     * @return
     */
    @GetMapping(value = "/bushouIndex")
    public JsonMsg bushouIndex(HttpServletRequest request){
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("wxSession");
        if (user == null){
            return new JsonMsg(true,"请重新登录",GlobalCode.FAIL,null);
        }
        //试用用户
        if (user.getType().equals("01")){
            int times = (int)request.getSession().getAttribute("times");
            if (times == 0){
                return new JsonMsg(true,"今日部首查询次数已满",GlobalCode.FAIL,null);
            }else {
                times--;
                request.getSession().setAttribute("times",times);
            }
        }

        logger.info(new Date() + "  user : " + user.getUsername() +
                " 使用 wx 进行部首查询");

        Map result = indexService.bushouIndex();
        return new JsonMsg(true,"获取笔画索引", GlobalCode.SUCCESS,result);

    }



    /**
     * 部首所属汉字
     @param bushou :部首ID
     */
    @GetMapping(value = "/bushou")
    public JsonMsg bushou(String bushou){
//        Session session = SecurityUtils.getSubject().getSession();
        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("wxSession");
        if (user == null){
            return new JsonMsg(true,"请重新登录",GlobalCode.FAIL,null);
        }
        Map result = indexService.bushou(bushou);
        return new JsonMsg(true,"获取笔画索引", GlobalCode.SUCCESS,result);
    }
}
