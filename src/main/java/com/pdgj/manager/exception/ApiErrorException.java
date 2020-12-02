package com.pdgj.manager.exception;

import java.util.Map;

public class ApiErrorException extends IllegalArgumentException {
    private static final long serialVersionUID = 1L;
    private String errorMsg;
    private int code;

    public ApiErrorException() {
        super();
    }

    public ApiErrorException(int code) {
        super(ErrorConstant.messageMap.get(code));
        this.code = code;
        this.errorMsg = ErrorConstant.messageMap.get(code);
    }

    /**
     * 替换提示消息
     *
     * @param code
     * @param keys
     */
    public ApiErrorException(int code, Map<String, String> keys) {
        super(ErrorConstant.messageMap.get(code));
        this.code = code;
        this.errorMsg = ErrorConstant.messageMap.get(code);
        //替换字符
        if (null != keys && !keys.isEmpty()) {
            for (String key : keys.keySet()) {
                this.errorMsg = this.errorMsg.replace("$" + key + "$", keys.get(key));
            }
        }
    }


    public ApiErrorException(String message, Throwable cause) {
        super(message, cause);
    }


    public ApiErrorException(Throwable cause) {
        super(cause);
    }

    /**
     * @return the errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * @param errorMsg the errorMsg to set
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
