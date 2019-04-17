package com.lyl.study.portal.configuration;

import com.lyl.study.portal.common.encoder.MD5PasswordEncoder;
import com.lyl.study.portal.common.encoder.PasswordEncoder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordEncoderConfiguration {
    /**
     * @return 默认使用MD5加密密码
     */
    @Bean
    @ConditionalOnMissingBean
    public PasswordEncoder md5PasswordEncoder() {
        return new MD5PasswordEncoder();
    }
}
