package com.update.model;

/**
 * Created by LiNan on 2018-08-21.
 * Description:
 */
//每一个读音一条数据，多音字有两条数据
public class PinyinNO {
    //汉字
    private String hanzi;
    //拼音+音调
    private String pinyin;
    //汉字顺序
    private String no;

    public String getHanzi() {
        return hanzi;
    }

    public void setHanzi(String hanzi) {
        this.hanzi = hanzi;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}
