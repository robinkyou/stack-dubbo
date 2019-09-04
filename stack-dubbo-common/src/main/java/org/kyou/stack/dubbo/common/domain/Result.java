package org.kyou.stack.dubbo.common.domain;

import org.kyou.stack.dubbo.common.enums.ErrorCodeEnum;

public class Result {
    private String code;
    private String message;

    public static Result buildCommonResult(ErrorCodeEnum codeEnum){
        Result result = new Result();
        result.setCode(codeEnum.getCode());
        result.setMessage(codeEnum.getMessage());
        return result;
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
