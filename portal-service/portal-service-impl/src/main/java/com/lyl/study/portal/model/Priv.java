package com.lyl.study.portal.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Document
public class Priv extends BaseModel implements Serializable {
    /**
     * 权限类型：E-权限标识，A-Ant表达式
     */
    private String privType;
    /**
     * 权限标识(逗号划分）
     * 如: system:user:read,system:user:write
     */
    private String privEl;
    /**
     * Ant表达式(逗号分割)
     */
    private String privAnt;
}