package com.lyl.study.portal.repository;

import com.lyl.study.portal.model.UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<UserInfo, String> {
}
