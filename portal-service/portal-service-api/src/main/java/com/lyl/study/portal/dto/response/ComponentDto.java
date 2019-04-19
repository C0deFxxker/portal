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
public class ComponentDto extends PrivDto implements Serializable {
    /**
     * 菜单ID
     */
    private String menuId;
    /**
     * 页面组件ID（Xpath）
     */
    private String objectId;
}