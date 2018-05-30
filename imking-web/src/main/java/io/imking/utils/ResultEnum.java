package io.imking.utils;

import io.imking.utils.exception.ExceptionEnum;

/**
 * Desc:
 *
 * @date: 09/11/2017
 * @author: gaul
 */
public enum ResultEnum implements ExceptionEnum {
    SUCCESS(200, "success"),
    SERVER_ERROR(500, "server error"),

    INVALID_PARAM(700,"invalid param"),
    RWASKQUESTION_NOT_EXIT(701,"rwAskQuestion is not exit."),
    RWASK_NOT_EXIT(702,"rwAsk is not exit."),

        ;

    private int code;
    private String desc;

    ResultEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
