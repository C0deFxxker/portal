package com.lyl.study.portal.dto.request;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class MenuSaveRequest implements Serializable {
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
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
     * 备注
     */
    private String comments;
}
