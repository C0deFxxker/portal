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
public class Portal extends BaseModel implements Serializable {
    /**
     * 根目录
     */
    @DBRef(lazy = true)
    private List<PortalDir> dirList = new ArrayList<>();
    /**
     * 根菜单
     */
    @DBRef(lazy = true)
    private List<PortalMenu> menuList = new ArrayList<>();
}