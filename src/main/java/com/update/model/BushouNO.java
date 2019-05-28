package com.update.model;

/**
 * Created by LiNan on 2018-08-14.
 * Description:
 */

//每一个汉字部首一条数据，多开门汉字有两条数据
public class BushouNO {
    private String hanzi;
    private String bushou;
    private String no;

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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
