package com.lyl.study.portal.dto.request;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class RoleUpdateRequest implements Serializable {
    /**
     * 角色ID
     */
    private String id;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 备注
     */
    private String comments;
}