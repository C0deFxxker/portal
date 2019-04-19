package com.lyl.study.portal.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Document
public class Component extends Priv implements Serializable {
    /**
     * 菜单ID
     */
    private String menuId;
    /**
     * 页面组件ID（Xpath）
     */
    private String objectId;
}
