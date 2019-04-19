package com.lyl.study.portal.dto.request;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class PortalUpdateSortRequest implements Serializable {
    /**
     * 门户ID
     */
    private String portalId;
    /**
     * 是否为菜单
     */
    private Boolean menuType;
    /**
     * 相关ID，可能是菜单ID或目录ID
     */
    private String partyId;
    /**
     * 旧序号
     */
    private Integer oldSort;
    /**
     * 新序号
     */
    private Integer newSort;
}
