package com.config.util.json;

/**
 * Created by linan on 2019-03-05
 * Description:
 */
public class JsonMsg {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 消息
     */
    private String message;

    /**
     * 返回码
     */
    private String code;

    /**
     * 数据
     */
    private Object data;

    /**
     * 初始化
     * @param success
     * @param message
     * @param code
     * @param data
     */
    public JsonMsg(boolean success, String message, String code, Object data){
        super();
        this.success = success;
        this.message = message;
        this.code = code;
        this.data = data;
    }

    /**
     *
     */
    public JsonMsg(){
    }

    /**
     *
     * @param success
     */
    public JsonMsg(boolean success){
        this.success = success;
    }

    /**
     *
     * @param success
     * @param message
     * @param code
     */
    public JsonMsg(boolean success, String message, String code){
        this(success);
        this.code = code;
        this.message = message;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString(){
        final StringBuffer sb = new StringBuffer("JsonMsg{");
        sb.append("success=").append(success);
        sb.append(", message='").append(message).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", data=").append(data);
        sb.append('}');
        return sb.toString();
    }
}
