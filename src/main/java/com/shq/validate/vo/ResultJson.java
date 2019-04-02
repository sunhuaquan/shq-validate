package com.shq.validate.vo;

/**
 * @author sunhuaquan
 * @Title: ResultJson
 * @ProjectName shq-validate
 * @Description: TODO
 * @date 2019/3/3115:16
 */
public class ResultJson<T> {

    private static final String SUCCESS_CODE = "0";

    private static final String ERROR_CODE = "1";

    private String errorCode;

    private String errorMsg;

    private T data;

    public ResultJson() {

    }

    public ResultJson(String errorCode, String errorMsg, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public static ResultJson success() {
        return new ResultJson<>(SUCCESS_CODE, null, null);
    }

    public static <T> ResultJson<T> success(T data) {
        return new ResultJson<>(SUCCESS_CODE, null, data);
    }

    public static <T> ResultJson<T> error(String errorMsg) {
        return new ResultJson<>(ERROR_CODE, errorMsg, null);
    }

    public static <T> ResultJson<T> error(String errorCode, String errorMsg) {
        return new ResultJson<>(errorCode, errorMsg, null);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
