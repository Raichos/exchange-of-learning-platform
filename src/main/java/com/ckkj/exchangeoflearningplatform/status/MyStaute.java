package com.ckkj.exchangeoflearningplatform.status;

/**
 * @author lzh
 * create 2019-05-08-22:51
 */

public enum MyStaute {


    SUCCESS(200, "success"),
    ERROR(500, "errorpage"),
    UNKNOWN_ERROR(-1, "unknown_error");

    private Integer code;
    private String msg;

    MyStaute(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
