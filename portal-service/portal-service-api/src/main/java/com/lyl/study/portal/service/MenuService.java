package com.lyl.study.portal.service;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.request.MenuSaveRequest;
import com.lyl.study.portal.dto.request.MenuUpdateRequest;
import com.lyl.study.portal.dto.response.MenuDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MenuService {
    Mono<MenuDto> save(MenuSaveRequest request);

    Mono<Void> update(MenuUpdateRequest request);

    Mono<Void> deleteById(String id);

    Mono<Void> deleteByIdList(List<String> idList);

    Mono<MenuDto> getById(String id);

    Mono<List<MenuDto>> getByIdList(List<String> idList);

    Mono<PageInfo<MenuDto>> page(String nameOrCodeLike, String tenantId, int pageIndex, int pageSize);
}