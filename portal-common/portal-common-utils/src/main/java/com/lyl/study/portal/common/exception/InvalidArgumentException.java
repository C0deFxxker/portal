package com.lyl.study.portal.common.exception;

import com.lyl.study.portal.common.CommonErrorCode;
import org.springframework.boot.logging.LogLevel;

public class InvalidArgumentException extends BaseException {
    public InvalidArgumentException(String msg) {
        super(CommonErrorCode.BAD_REQUEST, msg);
    }

    public InvalidArgumentException(String msg, LogLevel logLevel) {
        super(CommonErrorCode.BAD_REQUEST, msg, logLevel);
    }

    public InvalidArgumentException(int code, String msg) {
        super(code, msg);
    }

    public InvalidArgumentException(int code, String msg, LogLevel logLevel) {
        super(code, msg, logLevel);
    }
}
