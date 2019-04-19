package com.lyl.study.portal.service;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.response.MenuDto;
import reactor.core.publisher.Mono;

public interface MenuService {
    Mono<MenuDto> save();

    Mono<Void> update();

    Mono<Void> deleteById(String id);

    Mono<MenuDto> getById(String id);

    Mono<PageInfo<MenuDto>> page(int pageIndex, int pageSize);
}
