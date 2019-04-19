package com.lyl.study.portal.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class MenuDto extends PrivDto implements Serializable {
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
}
