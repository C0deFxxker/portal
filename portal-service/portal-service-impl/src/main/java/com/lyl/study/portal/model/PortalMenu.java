package com.lyl.study.portal.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
@Document
public class PortalMenu implements Serializable {
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 门户ID
     */
    private String tenantId;
    /**
     * 门户ID
     */
    private String portalId;
    /**
     * 目录ID（可以为空）
     */
    private String dirId;
    /**
     * 序号
     */
    private Integer sort;
    /**
     * 菜单
     */
    @DBRef
    private Menu menu;
}