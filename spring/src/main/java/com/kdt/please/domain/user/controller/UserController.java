package com.kdt.please.domain.user.controller;

import com.kdt.please.domain.resume.service.request.ResumeCreateRequest;
import com.kdt.please.domain.user.UserRole;
import com.kdt.please.domain.user.service.request.UserInfoRequest;
import com.kdt.please.domain.user.service.request.UserUpdateRequest;
import com.kdt.please.domain.user.service.response.UserInfoResponse;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @ApiOperation("회원가입 추가정보 입력 (구직자)")
    @PostMapping("/{userId}")
    public ResponseEntity<Void> createUserInfo(@PathVariable final Long userId, @RequestBody @Valid UserInfoRequest userInfoRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("내 정보 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable final Long userId){
        return ResponseEntity.ok(UserInfoResponse.builder()
                .id(1L)
                .email("d@d")
                .address("seoul")
                .name("leejoohee")
                .phone("010-1111-1111")
                .gender("female")
                .role(UserRole.ROLE_USER)
                .hexaco("[3.5, 3.5, 3.5, 3.5, 3.5, 3.5]")
                .period(5)
                .birthdate(LocalDate.parse("2023-01-01"))
                .profileImage("http://dfdfsdf")
                .build());
    }

    @ApiOperation("내 정보 수정")
    @PutMapping("/{userId}")
    public ResponseEntity<UserUpdateRequest> updateUserInfo(@PathVariable final Long userId){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("공고에 지원한 지원자 리스트 조회")
    @GetMapping("/recruits/{recruitId}")
    public ResponseEntity<List<UserInfoResponse>> getAppliedUserList(@PathVariable final Long recruitId){
        ArrayList<UserInfoResponse> userList = new ArrayList<>();
        userList.add(UserInfoResponse.builder()
                .id(1L)
                .email("d@d")
                .address("seoul")
                .name("leejoohee")
                .phone("010-1111-1111")
                .gender("female")
                .role(UserRole.ROLE_USER)
                .hexaco("[3.5, 3.5, 3.5, 3.5, 3.5, 3.5]")
                .period(5)
                .birthdate(LocalDate.parse("2023-01-01"))
                .profileImage("http://dfdfsdf")
                .build());
        return ResponseEntity.ok(userList);
    }

}
