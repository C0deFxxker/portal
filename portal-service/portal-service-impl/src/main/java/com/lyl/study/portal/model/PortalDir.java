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
public class PortalDir extends BaseModel implements Serializable {
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
     * 子目录
     */
    @DBRef(lazy = true)
    private List<PortalDir> dirList = new ArrayList<>();
    /**
     * 门户菜单
     */
    @DBRef(lazy = true)
    private List<PortalMenu> menuList = new ArrayList<>();
}
