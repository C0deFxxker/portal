package com.lyl.study.portal.dto.response;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
public class RoleDto implements Serializable {
    /**
     * 主键
     */
    private String id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 是否为管理员角色（管理员角色不允许修改和删除）
     */
    private Boolean admin;
    /**
     * 备注
     */
    private String comments;
    /**
     * 创建者ID
     */
    private String creatorId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
