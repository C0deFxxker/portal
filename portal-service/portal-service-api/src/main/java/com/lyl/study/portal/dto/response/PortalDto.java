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
@Accessors(chain = true)
public class PortalDto extends BaseDto implements Serializable {
}