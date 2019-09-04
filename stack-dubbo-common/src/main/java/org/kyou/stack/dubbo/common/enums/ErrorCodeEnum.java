package org.kyou.stack.dubbo.common.enums;

public enum ErrorCodeEnum {
    SUCCESS("0000","成功"),
    FAIL("0001","失败"),
    UNIQUE_INDEX("0002","数据已存在"),
    EXCEPTION("9999","未知异常");

    private String code;
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
