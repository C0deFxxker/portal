package com.lyl.study.portal.service.impl;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.request.PortalAddDirRequest;
import com.lyl.study.portal.dto.request.PortalSaveRequest;
import com.lyl.study.portal.dto.request.PortalUpdateRequest;
import com.lyl.study.portal.dto.request.PortalUpdateSortRequest;
import com.lyl.study.portal.dto.response.PortalDirDto;
import com.lyl.study.portal.dto.response.PortalDirMenuDto;
import com.lyl.study.portal.dto.response.PortalDto;
import com.lyl.study.portal.service.PortalService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PortalServiceImpl implements PortalService {
    @Override
    public Mono<PortalDto> save(PortalSaveRequest request) {
        return null;
    }

    @Override
    public Mono<Void> update(PortalUpdateRequest request) {
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
    public Mono<PortalDto> getById(String id) {
        return null;
    }

    @Override
    public Mono<List<PortalDto>> getByIdList(List<String> idList) {
        return null;
    }

    @Override
    public Mono<PageInfo<PortalDto>> page(String nameOrCodeLike, String tenantId, int pageIndex, int pageSize) {
        return null;
    }

    @Override
    public Mono<PortalDirDto> addDirToPortal(PortalAddDirRequest request) {
        return null;
    }

    @Override
    public Mono<Void> deleteDirFromPortal(String portalId, String dirId) {
        return null;
    }

    @Override
    public Mono<Void> addMenuToPortal(String portalId, String parentId, String menuId) {
        return null;
    }

    @Override
    public Mono<Void> deleteMenuFromPortal(String portalId, String menuId, int sort) {
        return null;
    }

    @Override
    public Mono<PortalDirMenuDto> getPortalDirsByPortalId(String portalId) {
        return null;
    }

    @Override
    public Mono<PortalDirMenuDto> getPortalDirMenusByPortalId(String portalId) {
        return null;
    }

    @Override
    public Mono<Void> updatePortalSort(List<PortalUpdateSortRequest> updateSortRequests) {
        return null;
    }
}
