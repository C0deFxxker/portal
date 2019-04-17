package com.lyl.study.portal.common.encoder;

public interface PasswordEncoder {
    /**
     * 对原文进行加密
     *
     * @param rawPassword 原文
     * @return 密文
     */
    String encode(String rawPassword);

    /**
     * 将原文与密文匹配
     *
     * @param rawPassword       原文
     * @param encryptedPassword 密文
     * @return 判断原文加密后是否与密文一致
     */
    boolean match(String rawPassword, String encryptedPassword);
}
