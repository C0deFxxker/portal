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
public class Role extends BaseModel implements Serializable {
    /**
     * 是否为管理员角色（管理员角色不允许修改和删除）
     */
    private Boolean admin;
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
     * 授权用户
     */
    @DBRef(lazy = true)
    private List<UserInfo> userList = new ArrayList<>();
}
