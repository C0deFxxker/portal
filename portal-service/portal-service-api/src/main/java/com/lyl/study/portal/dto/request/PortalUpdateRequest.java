package com.lyl.study.portal.dto.request;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@ToString
@Accessors(chain = true)
public class PortalUpdateRequest implements Serializable {
    private String id;
    private String name;
    private String comments;
}
