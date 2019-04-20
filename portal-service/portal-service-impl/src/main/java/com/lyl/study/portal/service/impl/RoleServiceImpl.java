package com.lyl.study.portal.service.impl;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.request.RoleAddPrivRequest;
import com.lyl.study.portal.dto.request.RoleSaveRequest;
import com.lyl.study.portal.dto.request.RoleUpdateRequest;
import com.lyl.study.portal.dto.response.*;
import com.lyl.study.portal.service.RoleService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Mono<RoleDto> save(RoleSaveRequest request) {
        return null;
    }

    @Override
    public Mono<Void> update(RoleUpdateRequest request) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return null;
    }

    @Override
    public Mono<Void> deleteByIdList(List<String> idList) {
        return null;
    }

    @Override
    public Mono<RoleDto> getById(String id) {
        return null;
    }

    @Override
    public Mono<List<RoleDto>> getByIdList(List<String> idList) {
        return null;
    }

    @Override
    public Mono<PageInfo<RoleDto>> page(String nameOrCodeLike, String tenantId, int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public Mono<Void> addMenuToRole(List<String> menuIdList) {
        return null;
    }

    @Override
    public Mono<Void> deleteMenuFromRole(List<String> menuIdList) {
        return null;
    }

    @Override
    public Mono<List<MenuDto>> getRoleMenusByRoleId(String roleId) {
        return null;
    }

    @Override
    public Mono<Void> addComponentToRole(List<String> componentIdList) {
        return null;
    }

    @Override
    public Mono<Void> deleteComponentFromRole(List<String> componentIdList) {
        return null;
    }

    @Override
    public Mono<List<ComponentDto>> getRoleComponentsByRoleId(String roleId) {
        return null;
    }

    @Override
    public Mono<List<PrivDto>> addPrivToRole(RoleAddPrivRequest request) {
        return null;
    }

    @Override
    public Mono<Void> deletePrivFromRole(List<String> privIdList) {
        return null;
    }

    @Override
    public Mono<List<PrivDto>> getRolePrivsByRoleId(String roleId) {
        return null;
    }

    @Override
    public Mono<Void> addPortalToRole(List<String> portalIdList) {
        return null;
    }

    @Override
    public Mono<Void> deletePortalFromRole(List<String> portalIdList) {
        return null;
    }

    @Override
    public Mono<List<PortalDto>> getRolePortalsByRoleId(String roleId) {
        return null;
    }

    @Override
    public Mono<Void> addUserToRole(List<String> userIdList) {
        return null;
    }

    @Override
    public Mono<Void> deleteUserFromRole(List<String> userIdList) {
        return null;
    }

    @Override
    public Mono<List<UserInfoDto>> getRoleUsersByRoleId(String roleId) {
        return null;
    }
}
