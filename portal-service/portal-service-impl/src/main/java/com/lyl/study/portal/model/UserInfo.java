package com.lyl.study.portal.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Document
public class UserInfo extends BaseModel implements Serializable {
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
     * 用户是否锁定(锁定的用户不能登录)
     */
    private Boolean locked;
    /**
     * 特殊授权
     */
    @DBRef(lazy = true)
    private List<Priv> privsList = new ArrayList<>();
    /**
     * 授权菜单
     */
    @DBRef(lazy = true)
    private List<Menu> menuList = new ArrayList<>();
    /**
     * 授权门户
     */
    @DBRef(lazy = true)
    private List<Portal> portalList = new ArrayList<>();
    /**
     * 授权角色
     */
    @DBRef(lazy = true)
    private List<Role> roleList = new ArrayList<>();
}