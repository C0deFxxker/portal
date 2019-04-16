package com.lyl.study.portal.common.exception;

import org.springframework.boot.logging.LogLevel;

public class NoSuchDependentedEntityException extends NoSuchEntityException {
    public NoSuchDependentedEntityException(String msg) {
        super(msg);
    }

    public NoSuchDependentedEntityException(String msg, LogLevel logLevel) {
        super(msg, logLevel);
    }

    public NoSuchDependentedEntityException(int code, String msg) {
        super(code, msg);
    }

    public NoSuchDependentedEntityException(int code, String msg, LogLevel logLevel) {
        super(code, msg, logLevel);
    }
}
