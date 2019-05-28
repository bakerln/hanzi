package com.update.model;

/**
 * Created by LiNan on 2018-06-26.
 * Description:
 */
public class Bushou {

    //部首ID
    private String id;
    private String hanzi;
    //部首本身
    private String bushou;
    //笔画数
    private String num;
    //部首图
    private String img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHanzi() {
        return hanzi;
    }

    public void setHanzi(String hanzi) {
        this.hanzi = hanzi;
    }

    public String getBushou() {
        return bushou;
    }

    public void setBushou(String bushou) {
        this.bushou = bushou;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
