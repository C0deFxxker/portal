package com.lyl.study.portal.dto.request;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class UserUpdateRequest implements Serializable {
    /**
     * 用户ID
     */
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 备注
     */
    private String memo;
}
