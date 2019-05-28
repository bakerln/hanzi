package com.update.model;

/**
 * Created by LiNan on 2018-06-05.
 * Description:
 */
public class Relation {
    //RelationID xxx_yy(xxx为汉字id，yy为笔画顺序id)
    private String id;
    //汉字ID
    private String hanzi_id;
    //汉字
    private String hanzi;
    //笔画ID （1-z）
    private String bihua_id;
    //笔画名称
    private String bihua;
    //笔画顺序
    private String no;
    //笔画图片
    private String url;

    public String getBihua() {
        return bihua;
    }

    public void setBihua(String bihua) {
        this.bihua = bihua;
    }

    public String getHanzi() {
        return hanzi;
    }

    public void setHanzi(String hanzi) {
        this.hanzi = hanzi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHanzi_id() {
        return hanzi_id;
    }

    public void setHanzi_id(String hanzi_id) {
        this.hanzi_id = hanzi_id;
    }

    public String getBihua_id() {
        return bihua_id;
    }

    public void setBihua_id(String bihua_id) {
        this.bihua_id = bihua_id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
