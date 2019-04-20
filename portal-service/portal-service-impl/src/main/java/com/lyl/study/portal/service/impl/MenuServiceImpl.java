package com.lyl.study.portal.service.impl;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.request.MenuSaveRequest;
import com.lyl.study.portal.dto.request.MenuUpdateRequest;
import com.lyl.study.portal.dto.response.MenuDto;
import com.lyl.study.portal.service.MenuService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Override
    public Mono<MenuDto> save(MenuSaveRequest request) {
        return null;
    }

    @Override
    public Mono<Void> update(MenuUpdateRequest request) {
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
    public Mono<MenuDto> getById(String id) {
        return null;
    }

    @Override
    public Mono<List<MenuDto>> getByIdList(List<String> idList) {
        return null;
    }

    @Override
    public Mono<PageInfo<MenuDto>> page(String nameOrCodeLike, String tenantId, int pageIndex, int pageSize) {
        return null;
    }
}
