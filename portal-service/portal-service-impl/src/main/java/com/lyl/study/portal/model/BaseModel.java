package com.lyl.study.portal.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@ToString
@Accessors(chain = true)
public abstract class BaseModel {
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
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
    /**
     * 逻辑删除
     */
    private Boolean deleted;
    /**
     * 创建者ID
     */
    private String creatorId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
}