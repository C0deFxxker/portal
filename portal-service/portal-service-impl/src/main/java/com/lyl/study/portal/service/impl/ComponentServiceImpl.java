package com.lyl.study.portal.service.impl;

import com.lyl.study.portal.dto.request.ComponentSaveRequest;
import com.lyl.study.portal.dto.request.ComponentUpdateRequest;
import com.lyl.study.portal.dto.response.ComponentDto;
import com.lyl.study.portal.service.ComponentService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class ComponentServiceImpl implements ComponentService {
    @Override
    public Mono<ComponentDto> save(ComponentSaveRequest request) {
        return null;
    }

    @Override
    public Mono<Void> update(ComponentUpdateRequest request) {
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
    public Mono<Void> deleteByMenuId(String menuId) {
        return null;
    }

    @Override
    public Mono<Void> deleteByMenuIdList(List<String> menuId) {
        return null;
    }

    @Override
    public Mono<ComponentDto> getById(String id) {
        return null;
    }

    @Override
    public Mono<List<ComponentDto>> getByIdList(List<String> idList) {
        return null;
    }

    @Override
    public Mono<List<ComponentDto>> getByMenuId(String menuId) {
        return null;
    }
}
