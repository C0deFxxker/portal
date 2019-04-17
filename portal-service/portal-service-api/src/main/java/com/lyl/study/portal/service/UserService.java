package com.lyl.study.portal.service;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.request.UserSaveRequest;
import com.lyl.study.portal.dto.request.UserUpdateRequest;
import com.lyl.study.portal.dto.response.UserInfoDto;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserInfoDto> save(UserSaveRequest request);

    Mono<Void> update(UserUpdateRequest request);

    Mono<Void> deleteById(String id);

    Mono<UserInfoDto> getById(String id);

    Mono<PageInfo<UserInfoDto>> page(String nameOrCodeLike, int pageIndex, int pageSize);
}
