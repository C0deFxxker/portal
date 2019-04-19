package com.lyl.study.portal.dto.request;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class RoleSaveRequest implements Serializable {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色编码
     */
    private String code;
    /**
     * 租户ID
     */
    private String tenantId;
    /**
     * 备注
     */
    private String comments;
}
