package com.config.util.global;

/**
 * Created by LiNan on 2019-01-30.
 * Description: 代码标识
 */
public class GlobalCode {
    //LOGIN
    public final static String LOGIN_SUCCESS= "050601"; //成功
    public final static String LOGIN_FAIL = "050602"; //失败

    public final static String DATAERROR_1 = "030021";//请求必输数据有null
    public final static String DATAERROR_2 = "030022";//请求数据有错误
    public final static String DATAERROR_3 = "030023";//验签错误
    public final static String DATAERROR_4 = "030024";//数据保护不允许删除（权限存在子节点）

    //LOGIN_LOG|DEPT|USER|ROLE
    public final static String SUCCESS = "00"; //成功
    public final static String FAIL = "01"; //失败
    public final static String ERROR = "02"; //异常


    //USERLOGIN|ROLE|PERMISSION|DEPT|USER
    public final static String NORMAL = "01"; //正常
    public final static String DELETE = "02"; //删除
    public final static String LOCKED = "03"; //锁定

    //USER
    public final static String MERCHANTUSER = "01";//商户用户
    public final static String DEPTUSER = "02"; //机构用户



}
