package com.lzdn.sys.common;

/**
 * upms系统接口结果常量枚举类
 * @author realMess
 *
 */
public enum SysResultConstant {

    /**
     * 失败
     */
    FAILED(0, "failed"),

    /**
     * 成功
     */
    SUCCESS(1, "success"),

    /**
     * 无效长度
     */
    INVALID_LENGTH(10001, "Invalid length"),

    /**
     * 用户名不能为空
     */
    EMPTY_USERNAME(10101, "Username cannot be empty"),

    /**
     * 密码不能为空
     */
    EMPTY_PASSWORD(10102, "Password cannot be empty"),

    /**
     * 帐号不存在
     */
    INVALID_USERNAME(10103, "Account does not exist"),

    /**
     * 密码错误
     */
    INVALID_PASSWORD(10104, "Password error"),

    /**
     * 无效帐号
     */
    INVALID_ACCOUNT(10105, "Invalid account"),
    /**
     * 内部错误
     */
    INTERNAL_ERROR(10106, "internal error");

    public int code;

    public String message;

    SysResultConstant(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
