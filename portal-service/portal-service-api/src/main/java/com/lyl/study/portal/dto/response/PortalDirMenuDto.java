package com.lyl.study.portal.dto.response;

import com.lyl.study.portal.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors
public class PortalDirMenuDto extends BaseDto implements Serializable {
    /**
     * 是否菜单
     * <p>该值为true时，id字段表示菜单ID；否则，id字段表示目录ID</p>
     */
    private Boolean menuType;
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
     * 父目录ID
     */
    private String parentId;
    /**
     * 序号
     */
    private Integer sort;
}
