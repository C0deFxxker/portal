package com.lyl.study.portal.service;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.request.UserSaveRequest;
import com.lyl.study.portal.dto.request.UserUpdateRequest;
import com.lyl.study.portal.dto.response.*;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserService {
    Mono<UserInfoDto> save(UserSaveRequest request);

    Mono<Void> update(UserUpdateRequest request);

    Mono<Void> deleteById(String id);

    Mono<Void> deleteByIdList(List<String> idList);

    Mono<UserInfoDto> getById(String id);

    Mono<UserInfoDto> getByIdList(List<String> idList);

    Mono<PageInfo<UserInfoDto>> page(String nameOrCodeLike, String tenantId, int pageIndex, int pageSize);

    Mono<Void> updatePassword(String id, String newPassword);

    Mono<Void> lock(String id);

    Mono<Void> unlock(String id);

    Mono<Void> addMenuToUser(List<String> menuIdList);

    Mono<Void> deleteMenuFromUser(List<String> menuIdList);

    Mono<List<MenuDto>> getUserMenusByUserId(String userId);

    Mono<Void> addComponentToUser(List<String> componentIdList);

    Mono<Void> deleteComponentFromUser(List<String> componentIdList);

    Mono<List<ComponentDto>> getUserComponentsByUserId(String userId);

    Mono<Void> addPortalToUser(List<String> portalIdList);

    Mono<Void> deletePortalFromUser(List<String> portalIdList);

    Mono<List<PortalDto>> getUserPortalsByUserId(String userId);

    Mono<Void> addRoleToUser(List<String> roleIdList);

    Mono<Void> deleteRoleFromUser(List<String> roleIdList);

    Mono<List<RoleDto>> getUserRolesByUserId(String userId);
}
