package com.lyl.study.portal.service;

import com.lyl.study.portal.dto.request.ComponentSaveRequest;
import com.lyl.study.portal.dto.request.ComponentUpdateRequest;
import com.lyl.study.portal.dto.response.ComponentDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ComponentService {
    Mono<ComponentDto> save(ComponentSaveRequest request);

    Mono<Void> update(ComponentUpdateRequest request);

    Mono<Void> deleteById(String id);

    Mono<Void> deleteByIdList(List<String> idList);

    Mono<Void> deleteByMenuId(String menuId);

    Mono<Void> deleteByMenuIdList(List<String> menuId);

    Mono<ComponentDto> getById(String id);

    Mono<List<ComponentDto>> getByIdList(List<String> idList);

    Mono<List<ComponentDto>> getByMenuId(String menuId);
}
