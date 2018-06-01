package com.config.util.string;

import javax.servlet.http.HttpServletRequest;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by LiNan on 2018-04-09.
 * Description:
 */
public class StringUtil {
    private static final char[] codeSequenceRandom = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0' };

    private static final String  mobilrex = "^1(3[0-9]|4[57]|5[0-35-9]|7[01678]|8[0-9])\\d{8}$";
    /**
     * 判断字符串是null或空
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        if (str == null || str.equals(""))
            return true;
        else
            return false;
    }

    /**
     * 判断是否是ajax请求
     * @param request
     * @return
     */
    public static boolean checkAjaxRequest(HttpServletRequest request) {
        String requestType = request.getHeader("X-Requested-With");
        if (requestType != null && requestType.equalsIgnoreCase("XMLHttpRequest")) {
            return true;
        } else
            return false;
    }

    /**
     * 格式化金钱
     *
     * @param val
     * @return
     */
    public static String formatAmount(double val) {
        NumberFormat nf = new DecimalFormat("#,###.##");
        String str = nf.format(val);
        return str;
    }

    /**
     * 获取ip地址
     * @param request
     * @return
     */
    public static String getIp(HttpServletRequest request) {
        String szClientIP = request.getHeader("x-forwarded-for");
        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
            szClientIP = request.getHeader("Proxy-Client-IP");
        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
            szClientIP = request.getHeader("WL-Proxy-Client-IP");
        if (szClientIP == null || szClientIP.length() == 0 || "unknown".equalsIgnoreCase(szClientIP))
            szClientIP = request.getRemoteAddr();
        return szClientIP;
    }

    /**
     * 生成字符串随机数
     * @param count
     * @return
     */
    public static String createRandomCode(int count) {
        String serialNum = "";
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String strRand = String.valueOf(codeSequenceRandom[random.nextInt(codeSequenceRandom.length)]);
            serialNum += strRand;
        }
        return serialNum;
    }

    /**
     * 判断是否是电话号码
     * @param phoneNum
     * @return
     */
    public static Boolean isPhoneNum(String phoneNum){
        Pattern p = Pattern.compile(mobilrex);
        Matcher m = p.matcher(phoneNum);
        return m.matches();
    }

    /**
     * 根据字符串转换，如果为null，则变成""
     * @param obj
     * @return
     */
    public static String getSafeStr(Object obj) {
        return obj == null ? "" : String.valueOf(obj);
    }

    /**
     * 根据字符串转换，如果为null，则变成defaultStr
     * @param obj
     * @param strDefault
     * @return
     */
    public static String getSafeStr(Object obj, String strDefault) {
        return obj == null ? strDefault : String.valueOf(obj);
    }

    /**
     * 根据字符串转换，如果为null，则变成0
     * @param obj
     * @return
     */
    public static int getSafeInt(Object obj) {
        return obj == null || obj.toString().equals("") ? 0 : Integer.parseInt(String.valueOf(obj));
    }

    /**
     * 根据字符串转换，如果为null，则变成defaultInt
     * @param obj
     * @param nDefualt
     * @return
     */
    public static int getSafeInt(Object obj, int nDefualt) {
        return obj == null || obj.toString().equals("") ? nDefualt : Integer.parseInt(String.valueOf(obj));
    }

    /**
     * 根据字符串转换，如果为null，则变成0
     * @param obj
     * @return
     */
    public static double getSafeDouble(Object obj) {
        return obj == null ? 0 : Double.parseDouble(String.valueOf(obj));
    }

    /**
     * 根据字符串转换，如果为null，则变成defaultDouble
     * @param obj
     * @param nDefualt
     * @return
     */
    public static double getSafeDouble(Object obj, double nDefualt) {
        return obj == null ? 0 : Double.parseDouble(String.valueOf(obj));
    }

    /**
     * double 取舍一位小数
     * @param num
     * @return
     */
    public static double getOneDecimal(double num) {
        DecimalFormat format = new DecimalFormat("#.0");
        String numString = format.format(num);
        Double temp= Double.valueOf(numString);
        return temp;
    }
}
