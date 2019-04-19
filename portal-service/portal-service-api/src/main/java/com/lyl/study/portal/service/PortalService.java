package com.lyl.study.portal.service;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.request.PortalAddDirRequest;
import com.lyl.study.portal.dto.request.PortalSaveRequest;
import com.lyl.study.portal.dto.request.PortalUpdateRequest;
import com.lyl.study.portal.dto.request.PortalUpdateSortRequest;
import com.lyl.study.portal.dto.response.PortalDirDto;
import com.lyl.study.portal.dto.response.PortalDirMenuDto;
import com.lyl.study.portal.dto.response.PortalDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PortalService {
    Mono<PortalDto> save(PortalSaveRequest request);

    Mono<Void> update(PortalUpdateRequest request);

    Mono<Void> deleteById(String id);

    Mono<PortalDto> getById(String id);

    Mono<PageInfo<PortalDto>> page(int pageIndex, int pageSize);

    Mono<PortalDirDto> addDirToPortal(PortalAddDirRequest request);

    Mono<Void> deleteDirFromPortal(String portalId, String dirId);

    Mono<Void> addMenuToPortal(String portalId, String parentId, String menuId);

    Mono<Void> deleteMenuFromPortal(String portalId, String menuId, int sort);

    Mono<PortalDirMenuDto> getPortalDirsByPortalId(String portalId);

    Mono<PortalDirMenuDto> getPortalDirMenusByPortalId(String portalId);

    Mono<Void> updatePortalSort(List<PortalUpdateSortRequest> updateSortRequests);
}