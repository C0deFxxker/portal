package com.lyl.study.portal.dto.request;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class PortalAddDirRequest implements Serializable {
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 门户ID
     */
    private String portalId;
    /**
     * 父目录ID
     */
    private String parentId;
    /**
     * 序号
     */
    private Integer sort;
    /**
     * 备注
     */
    private String comments;
}
