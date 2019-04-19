package com.lyl.study.portal.service;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.request.RoleAddPrivRequest;
import com.lyl.study.portal.dto.request.RoleSaveRequest;
import com.lyl.study.portal.dto.request.RoleUpdateRequest;
import com.lyl.study.portal.dto.response.*;
import reactor.core.publisher.Mono;

import java.util.List;

public interface RoleService {
    Mono<RoleDto> save(RoleSaveRequest request);

    Mono<Void> update(RoleUpdateRequest request);

    Mono<Void> deleteById(String id);

    Mono<RoleDto> getById(String id);

    Mono<PageInfo<RoleDto>> page(String nameOrCodeLike, int pageIndex, int pageSize);

    Mono<Void> addMenuToRole(List<String> menuIdList);

    Mono<Void> deleteMenuFromRole(List<String> menuIdList);

    Mono<List<MenuDto>> getRoleMenusByRoleId(String roleId);

    Mono<Void> addComponentToRole(List<String> componentIdList);

    Mono<Void> deleteComponentFromRole(List<String> componentIdList);

    Mono<List<ComponentDto>> getRoleComponentsByRoleId(String roleId);

    Mono<List<PrivDto>> addPrivToRole(RoleAddPrivRequest request);

    Mono<Void> deletePrivFromRole(List<String> privIdList);

    Mono<List<PrivDto>> getRolePrivsByRoleId(String roleId);

    Mono<Void> addPortalToRole(List<String> portalIdList);

    Mono<Void> deletePortalFromRole(List<String> portalIdList);

    Mono<List<PortalDto>> getRolePortalsByRoleId(String roleId);

    Mono<Void> addUserToRole(List<String> userIdList);

    Mono<Void> deleteUserFromRole(List<String> userIdList);

    Mono<List<UserInfoDto>> getRoleUsersByRoleId(String roleId);
}
