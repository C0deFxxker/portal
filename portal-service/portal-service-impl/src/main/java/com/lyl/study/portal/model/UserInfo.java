package com.lyl.study.portal.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.mongodb.morphia.annotations.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
@Document
@Entity
public class UserInfo implements Serializable {
    /**
     * 用户ID
     */
    @Id
    private String id;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户编码
     */
    private String code;
    /**
     * 用户密码
     */
    private String password;
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
    /**
     * 用户是否已删除
     */
    private Boolean deleted;
    /**
     * 用户是否锁定
     */
    private Boolean locked;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}