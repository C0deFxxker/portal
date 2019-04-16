package com.lyl.study.portal.common.autoconfigure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.lyl.study.portal.common.util.JsonUtils;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Configuration
@AutoConfigureBefore(name = "org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration")
public class SystemCommonConfig {
    final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Configuration
    @ConditionalOnClass(name = "org.springframework.web.client.RestTemplate")
    static class RestTemplateConfig {
        @Bean
        @ConditionalOnMissingBean
        public RestTemplate restTemplate() {
            return new RestTemplate();
        }
    }

    @Bean
    @ConditionalOnMissingBean
    public JsonUtils jsonUtils(ObjectMapper objectMapper) {
        return new JsonUtils(objectMapper);
    }

    @Bean
    @Primary
    @ConditionalOnMissingBean
    public ObjectMapper objectMapper() {
        ObjectMapper om = new ObjectMapper();

        // 设置时间格式
        om.setDateFormat(dateFormat);
        // 不用时间戳
        om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        // 遇到未知属性不报错
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 遇到空集合不报错
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //去掉值为null的字段的序列化，减少带宽，
        om.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return om;
    }
}