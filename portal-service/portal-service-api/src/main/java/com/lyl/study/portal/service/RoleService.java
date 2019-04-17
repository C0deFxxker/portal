package com.lyl.study.portal.service;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.request.RoleSaveRequest;
import com.lyl.study.portal.dto.request.RoleUpdateRequest;
import com.lyl.study.portal.dto.response.RoleDto;
import reactor.core.publisher.Mono;

public interface RoleService {
    Mono<RoleDto> save(RoleSaveRequest request);

    Mono<Void> update(RoleUpdateRequest request);

    Mono<Void> deleteById(String id);

    Mono<RoleDto> getById(String id);

    Mono<PageInfo<RoleDto>> page(String nameOrCodeLike, int pageIndex, int pageSize);

    // TODO 补充权限相关的接口
}
