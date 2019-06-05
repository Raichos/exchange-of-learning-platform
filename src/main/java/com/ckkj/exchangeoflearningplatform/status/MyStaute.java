package com.ckkj.exchangeoflearningplatform.status;

import lombok.Data;

/**
 * 状态返回
 *
 * @author lzh
 * create 2019-05-08-22:51
 */

public enum MyStaute {


    UNKNOWN_ERROR(-1, "unknown_error"),
    FALSE(0,"false"),
    SUCCESS(1,"true");

    private Integer code;
    private String msg;

    MyStaute(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
