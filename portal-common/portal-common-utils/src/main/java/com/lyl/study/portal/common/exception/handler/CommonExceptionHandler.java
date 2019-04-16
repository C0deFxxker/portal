package com.lyl.study.portal.common.exception.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lyl.study.portal.common.CommonErrorCode;
import com.lyl.study.portal.common.dto.Result;
import com.lyl.study.portal.common.exception.BaseException;
import com.lyl.study.portal.common.util.HttpServletUtils;
import com.lyl.study.portal.common.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 统一异常处理器
 *
 * @author liyilin
 */
@Slf4j
@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(Throwable.class)
    public void handleError(HttpServletRequest request, HttpServletResponse response) {
        Result<?> result = null;

        Object error = request.getAttribute("org.springframework.boot.autoconfigure.web.DefaultErrorAttributes.ERROR");
        if (error instanceof Throwable) {
            result = handleException((Throwable) error);
        }

        error = request.getAttribute("javax.servlet.error.exception");
        if (error instanceof Throwable) {
            result = handleException((Throwable) error);
        }

        if (result == null) {
            int code = Integer.parseInt(request.getAttribute("javax.servlet.error.status_code").toString());
            String message = request.getAttribute("javax.servlet.error.message").toString();
            String data = request.getAttribute("javax.servlet.error.request_uri").toString();

            result = new Result<>(code, message, data);
        }

        if (log.isDebugEnabled()) {
            log.debug("错误处理结果：" + result.toString());
        }

        renderResult(request, response, result);
    }

    public void renderResult(HttpServletRequest request, HttpServletResponse response, Result<?> result) {
        String uri = request.getRequestURI();
        if (uri.length() > 0) {
            String contextPath = request.getContextPath();
            if (contextPath.length() > 0 && !contextPath.equals("/")) {
                uri = uri.substring(contextPath.length());
            }
        }
        if (uri.startsWith("/api/")) {
            if (result.getCode() >= 400 && result.getCode() <= 500) {
                HttpServletUtils.writeJson(result.getCode(), result, response);
            } else {
                HttpServletUtils.writeJson(HttpStatus.INTERNAL_SERVER_ERROR.value(), result, response);
            }
        } else {
            HttpServletUtils.writeJson(HttpStatus.OK.value(), result, response);
        }
    }


    public Result<?> handleException(Throwable e) {
        while (e.getClass().equals(NestedServletException.class)) {
            e = e.getCause();
        }

        if (e instanceof BaseException) {
            return resolveBaseException((BaseException) e);
        } else if (e.getClass().getName().equals("feign.FeignException")) {
            return resolveFeignException(e);
        } else {
            return resolveCommonException(e);
        }
    }

    protected Result<?> resolveFeignException(Throwable e) {
        final String regex = "; content:\n";
        String message = e.getMessage();
        int idx = message.indexOf(regex);
        if (idx != -1) {
            String contentStr = message.substring(idx + regex.length() - 1);
            try {
                Map<String, Object> content = JsonUtils.fromJson(contentStr, new TypeReference<Map<String, Object>>() {
                });
                return new Result<>(CommonErrorCode.INTERNAL_ERROR, message.substring(0, idx), content);
            } catch (Exception e1) {
                // 内容不是Json串则直接输出
                return new Result<>(CommonErrorCode.INTERNAL_ERROR, message.substring(0, idx), contentStr);
            }
        } else {
            // 不符合以上格式的，暂放到通用处理
            return resolveCommonException(e);
        }
    }

    protected Result<?> resolveCommonException(Throwable e) {
        if (e instanceof MethodArgumentNotValidException) {
            StringBuilder msgBuilder = new StringBuilder();
            BindingResult bindingResult = ((MethodArgumentNotValidException) e).getBindingResult();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError eachError : allErrors) {
                if (eachError instanceof FieldError) {
                    String field = ((FieldError) eachError).getField();
                    String msg = eachError.getDefaultMessage();
                    msgBuilder.append(field).append(msg).append(",");
                } else {
                    Object o = eachError.getArguments()[0];
                    String msg = eachError.getDefaultMessage();
                    msgBuilder.append(o.toString()).append(msg).append(",");
                }
            }
            if (msgBuilder.length() > 0) {
                msgBuilder.deleteCharAt(msgBuilder.length() - 1);
            }

            Result result = new Result<>(CommonErrorCode.BAD_REQUEST, msgBuilder.toString(), null);

            if (log.isDebugEnabled()) {
                log.debug(result.toString());
            }

            return result;
        } else if (e instanceof IllegalArgumentException) {
            e.printStackTrace();
            return new Result<>(CommonErrorCode.BAD_REQUEST, e.getMessage(), null);
        } else if (e instanceof ServletRequestBindingException
                || e instanceof MissingServletRequestPartException) {
            return new Result<>(CommonErrorCode.BAD_REQUEST, e.getMessage(), null);
        } else {
            e.printStackTrace();
            return new Result<>(CommonErrorCode.INTERNAL_ERROR, e.getMessage(), e.toString());
        }
    }

    protected Result<?> resolveBaseException(BaseException e) {
        if (LogLevel.ERROR.equals(e.getLogLevel())) {
            log.error(e.toString());

            if (log.isDebugEnabled()) {
                log.debug("全局异常处理器捕捉到错误异常栈如下", e);
            }
        } else if (LogLevel.WARN.equals(e.getLogLevel())) {
            log.warn(e.toString());
        } else if (LogLevel.INFO.equals(e.getLogLevel())) {
            log.info(e.toString());
        } else if (LogLevel.TRACE.equals(e.getLogLevel())) {
            log.trace(e.toString());
        } else if (LogLevel.DEBUG.equals(e.getLogLevel()) && log.isDebugEnabled()) {
            log.debug(e.toString());
        }
        return e.toResult();
    }
}
