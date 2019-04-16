package com.lyl.study.portal.test;

import com.lyl.study.portal.common.dto.PageInfo;
import com.lyl.study.portal.dto.request.UserSaveRequest;
import com.lyl.study.portal.dto.request.UserUpdateRequest;
import com.lyl.study.portal.dto.response.UserInfoDto;
import com.lyl.study.portal.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void test1() {
        UserSaveRequest request = new UserSaveRequest();
        request.setName("test");
        request.setCode("test");
        request.setPassword("test");
        UserInfoDto persist = userService.save(request).block();
        Assert.notNull(persist, "新增操作没有返回用户信息");
        Assert.notNull(persist.getId(), "新增操作没有返回用户ID");
        Assert.isTrue(request.getName().equals(persist.getName()), "姓名不正确");
        Assert.isTrue(request.getCode().equals(persist.getCode()), "编码不正确");
        Assert.isTrue(request.getPassword().equals(persist.getPassword()), "密码不正确");

        Mono<UserInfoDto> userMono = userService.getById(persist.getId());

        StepVerifier
                .create(userMono)
                .assertNext(user -> {
                    Assert.isTrue(persist.getId().equals(user.getId()), "查询ID不正确");
                    Assert.isTrue(persist.getName().equals(user.getName()), "姓名不正确");
                    Assert.isTrue(persist.getCode().equals(user.getCode()), "编码不正确");
                    Assert.isTrue(persist.getPassword().equals(user.getPassword()), "密码不正确");
                })
                .expectComplete()
                .verify();

        UserUpdateRequest updateRequest = new UserUpdateRequest();
        updateRequest.setId(persist.getId());
        updateRequest.setName("test2");
        updateRequest.setPhone("13612345678");
        userService.update(updateRequest).block();

        userMono = userService.getById(persist.getId());
        StepVerifier
                .create(userMono)
                .assertNext(user -> {
                    Assert.isTrue(updateRequest.getName().equals(user.getName()), "姓名不正确");
                    Assert.isTrue(updateRequest.getPhone().equals(user.getPhone()), "手机号不正确");
                })
                .expectComplete()
                .verify();

        userMono = userService.deleteById(persist.getId())
                .then(userService.getById(persist.getId()));

        StepVerifier
                .create(userMono)
                .expectNextCount(0L)
                .expectComplete()
                .verify();
    }

    @Test
    public void testPage() {
        final int num = 20;
        final int pageSize = 10;
        for (int i = 1; i <= num; i++) {
            UserSaveRequest request = new UserSaveRequest();
            request.setName("test-" + i);
            request.setCode("test-" + i);
            request.setPassword("test-" + i);
            userService.save(request).block();
        }

        Mono<PageInfo<UserInfoDto>> pageMono = userService.page(1, pageSize);
        StepVerifier
                .create(pageMono)
                .assertNext(pageInfo -> {
                    Assert.isTrue(pageInfo.getTotal() >= num, "total值错误");
                    Assert.isTrue(pageInfo.getList().size() == pageSize, "list元素数目不正确");
                    pageInfo.getList().forEach(e -> {
                        Assert.notNull(e.getId(), "id为空");
                        Assert.notNull(e.getName(), "name为空");
                        Assert.notNull(e.getCode(), "code为空");
                        Assert.notNull(e.getPassword(), "password为空");
                    });
                })
                .expectComplete()
                .verify();
    }
}
