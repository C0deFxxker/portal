package com.lyl.study.portal.service.impl;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.common.encoder.PasswordEncoder;
import com.lyl.study.portal.dto.request.UserSaveRequest;
import com.lyl.study.portal.dto.request.UserUpdateRequest;
import com.lyl.study.portal.dto.response.UserInfoDto;
import com.lyl.study.portal.model.UserInfo;
import com.lyl.study.portal.repository.UserRepository;
import com.lyl.study.portal.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.Objects;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ReactiveMongoTemplate mongoTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Mono<UserInfoDto> save(UserSaveRequest request) {
        log.info("新建用户: {}", request);
        UserInfo model = new UserInfo();
        BeanUtils.copyProperties(request, model);
        model.setCreateTime(new Date());
        model.setUpdateTime(new Date());
        model.setDeleted(false);

        return userRepository.save(model).map(userInfo -> {
            UserInfoDto dto = new UserInfoDto();
            BeanUtils.copyProperties(userInfo, dto);
            log.info("新建用户成功: {}", dto);
            return dto;
        });
    }

    @Override
    public Mono<Void> update(UserUpdateRequest request) {
        log.info("修改用户: {}", request);
        return userRepository.findById(request.getId())
                .filter(userInfo -> userInfo != null && !Objects.equals(Boolean.TRUE, userInfo.getDeleted()))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("找不到ID为" + request.getId() + "的用户")))
                .flatMap(userInfo -> {
                    BeanUtils.copyProperties(request, userInfo);
                    userInfo.setUpdateTime(new Date());
                    return userRepository.save(userInfo);
                }).then();
    }

    @Override
    public Mono<Void> deleteById(String id) {
        log.info("删除用户: ID={}", id);
        return userRepository.findById(id)
                .filter(userInfo -> userInfo != null && !Objects.equals(Boolean.TRUE, userInfo.getDeleted()))
                .flatMap(userInfo -> {
                    userInfo.setDeleted(true);
                    userInfo.setUpdateTime(new Date());
                    return userRepository.save(userInfo);
                }).then();
    }

    @Override
    public Mono<UserInfoDto> getById(String id) {
        if (log.isDebugEnabled()) {
            log.debug("根据ID查询用户: ID={}", id);
        }

        return userRepository.findById(id)
                .filter(userInfo -> userInfo != null && !Objects.equals(Boolean.TRUE, userInfo.getDeleted()))
                .map(userInfo -> {
                    UserInfoDto dto = new UserInfoDto();
                    BeanUtils.copyProperties(userInfo, dto);
                    if (log.isDebugEnabled()) {
                        log.debug("根据ID查询用户成功: {}", dto);
                    }
                    return dto;
                });
    }

    @Override
    public Mono<PageInfo<UserInfoDto>> page(String nameOrCodeLike, int pageIndex, int pageSize) {
        if (log.isDebugEnabled()) {
            log.debug("分页获取用户列表: nameOrCodeLike={}, pageIndex={}, pageSize={}", pageIndex, pageSize);
        }

        Query query = new Query(where("deleted").is(Boolean.FALSE)
                .orOperator(where("name").regex(nameOrCodeLike, "i"), where("code").regex(nameOrCodeLike, "i")));

        return Mono.zip(
                mongoTemplate.count(query, UserInfo.class),
                Mono.from(mongoTemplate.find(query.skip(pageIndex * pageSize).limit(pageSize), UserInfo.class).map(userInfo -> {
                    UserInfoDto dto = new UserInfoDto();
                    BeanUtils.copyProperties(userInfo, dto);
                    return dto;
                }).buffer()),
                (total, userInfoList) -> new PageInfo<>(pageIndex, pageSize, total, userInfoList));
    }

    @Override
    public Mono<Void> updatePassword(String id, String newPassword) {
        log.info("修改用户密码: id={}", id);

        return userRepository.findById(id)
                .filter(userInfo -> userInfo != null && !Objects.equals(Boolean.TRUE, userInfo.getDeleted()))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("找不到ID为" + id + "的用户")))
                .flatMap(userInfo -> {
                    userInfo.setPassword(passwordEncoder.encode(newPassword));
                    userInfo.setUpdateTime(new Date());
                    return userRepository.save(userInfo);
                }).then();
    }

    @Override
    public Mono<Void> lock(String id) {
        return userRepository.findById(id)
                .filter(userInfo -> userInfo != null && !Objects.equals(Boolean.TRUE, userInfo.getDeleted()))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("找不到ID为" + id + "的用户")))
                .flatMap(userInfo -> {
                    userInfo.setLocked(true);
                    userInfo.setUpdateTime(new Date());
                    return userRepository.save(userInfo);
                }).then();
    }

    @Override
    public Mono<Void> unlock(String id) {
        return userRepository.findById(id)
                .filter(userInfo -> userInfo != null && !Objects.equals(Boolean.TRUE, userInfo.getDeleted()))
                .switchIfEmpty(Mono.error(new IllegalArgumentException("找不到ID为" + id + "的用户")))
                .flatMap(userInfo -> {
                    userInfo.setLocked(false);
                    userInfo.setUpdateTime(new Date());
                    return userRepository.save(userInfo);
                }).then();
    }
}
