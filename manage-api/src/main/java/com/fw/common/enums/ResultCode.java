package com.fw.common.enums;

public enum  ResultCode {
    /*** 通用部分 200 - 999***/
    SUCCESS(200, "successful"),//成功请求
    INTERNAL_ERROR(500, "internal error"),//未知异常，这个只有在异常没有捕获的时候才会出现
    INVOKE_EXCEPTION(100, "exception occur:%s"),//调用异常
    RESULT_IS_NULL(101, "result is null the id is:%s"),//返回结果为空
    SIGN_NOT_FOUND(186,"sign not found") ,//签名缺失
    ACCOUNT_NOT_LOGIN(401,"account not login"), // 账户未登录

    /**** 参数问题 100001-110000 ***/
    LACK_PARAM_ERROR(100001,"参数缺失"), // 缺少参数
    PARAMS_ERROR(100002, "参数不合法"), // 格式不对
    REPEAT_CALL(100003,"重复调用"),     // 并发
    DB_ERROR(100004, "数据库操作失败"),

    TOKEN_LACK_PARAM(100011, "缺少TOKEN相关参数"),
    TOKEN_ACCESS_TIMEOUT(100012, "Token授权超时"),


    /*** code 110001-200000 start*/
    ACCOUNT_EXITED(110001,"该账号已经存在!"),
    ACCOUNT_NOT_EXITED(110002,"该账号不存在！"),
    PASSWORD_EQUAL_OLD(110003, "新密码和旧密码不能相同!"),
    PASSWORD_ERROR(110004,"密码不正确！"),
    PASSWORD_LENGTH_SIX_ERROR(110005,"密码长度不能小于6位！"),


    SEND_PHONE_EXCEPTION(110010,"手机号当天发送次数过多!"),
    SEND_REPEAT_REQUEST(110011, "%s秒后方可重新发验证码！"),


    PHONE_PATTERN_ERROR(120001,"手机号码格式错误"),

    ;


    private int code;
    private String message;

    private ResultCode(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }

    public static ResultCode valueOf(int code) {
        for (ResultCode value : values()) {
            if (code == value.code) {
                return value;
            }
        }
        return SUCCESS; // default is successful
    }
}
