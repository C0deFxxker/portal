package com.lyl.study.portal.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * 该类还在整理，有待完善
 *
 * @author 黎毅麟
 */
public class HttpServletUtils {
    public static final String MEDIA_TYPE_APPLICATION_JSON = "application/json";

    private static final Logger logger = LoggerFactory.getLogger(HttpServletUtils.class);

    public static void writeJson(int status, Object obj, HttpServletResponse response) {
        response.setContentType(MEDIA_TYPE_APPLICATION_JSON);
        response.setCharacterEncoding(Charset.defaultCharset().displayName());

        try {
            response.setStatus(status);
            String json = JsonUtils.toJson(obj);
            response.getOutputStream().write(json.getBytes());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }

    public static Cookie getCookieByName(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie each : cookies) {
                String name = each.getName();
                if (name.equals(cookieName)) {
                    return each;
                }
            }
        }
        return null;
    }

    /**
     * 获取请求的真实IP
     *
     * @param request 请求对象
     * @return 请求的真实IP
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
