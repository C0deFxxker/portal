package com.lyl.study.portal.repository;

import com.lyl.study.portal.model.UserInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveMongoRepository<UserInfo, String> {
    @Query(value = "{ '_id': { $exists: true }}")
    Flux<UserInfo> findUsersPaged(final Pageable pageable);
}
