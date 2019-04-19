package com.lyl.study.portal.dto.request;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class PortalSaveRequest implements Serializable {
    private String code;
    private String name;
    private String comments;
}
