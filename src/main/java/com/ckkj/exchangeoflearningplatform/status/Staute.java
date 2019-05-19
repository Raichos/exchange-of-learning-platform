package com.ckkj.exchangeoflearningplatform.status;

/**
 * @author lzh
 * create 2019-05-08-22:51
 */

public enum Staute {


    SUCCESS(200, "success"),
    ERROR(500, "error"),
    UNKNOWN_ERROR(-1, "unknown_error");

    private Integer code;
    private String msg;

    Staute(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
