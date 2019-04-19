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
public class Menu extends Priv implements Serializable {
    /**
     * 页面类型：S: 单页，M: iframe，O：新窗口
     */
    private String pageType;
    /**
     * 页面URL
     */
    private String pageUrl;
    /**
     * 图标URL
     */
    private String iconUrl;
    /**
     * 是否可见
     */
    private Boolean visiable;
    /**
     * 组件列表
     */
    @DBRef
    private List<Component> componentList = new ArrayList<>();
}
