package com.fw.common.result;


import com.fw.common.enums.ResultCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResult<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    private boolean success;
    // 无参构造器
    public ApiResult() {
    }
    // 返回成功的实体
    public ApiResult(T obj) {
        this.code = 200;
        this.data = obj;
        this.success = true;
    }
    // 返回错误信息
    public ApiResult(ResultCode resultCode) {
        this.success = false;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }
    // 返回错误信息
    public ApiResult(int code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }



}
