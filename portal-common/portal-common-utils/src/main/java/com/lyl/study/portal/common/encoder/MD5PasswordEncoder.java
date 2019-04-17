package com.lyl.study.portal.common.encoder;

import com.lyl.study.portal.common.util.CryptoUtils;

import java.nio.charset.Charset;

public class MD5PasswordEncoder implements PasswordEncoder {
    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String encode(String rawPassword) {
        if (salt != null) {
            return CryptoUtils.md5String((rawPassword + salt).getBytes(Charset.forName("UTF-8")));
        } else {
            return CryptoUtils.md5String(rawPassword.getBytes(Charset.forName("UTF-8")));
        }
    }

    @Override
    public boolean match(String rawPassword, String encryptedPassword) {
        return encode(rawPassword).equals(encryptedPassword);
    }
}
