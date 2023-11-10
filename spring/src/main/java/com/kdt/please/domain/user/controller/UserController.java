package com.kdt.please.domain.user.controller;

import com.kdt.please.config.auth.LoginUser;
import com.kdt.please.config.auth.dto.SessionUser;
import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.UserRole;
import com.kdt.please.domain.user.repository.UserRepository;
import com.kdt.please.domain.user.service.UserService;
import com.kdt.please.domain.user.service.request.UserUpdateRequest;
import com.kdt.please.domain.user.service.response.UserInfoResponse;
import com.kdt.please.domain.userVisa.dto.UserVisaRequest;
import com.kdt.please.domain.userVisa.dto.UserVisaUpdateRequest;
import com.kdt.please.exception.BaseResponseStatus;
import com.kdt.please.exception.CustomException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation("ID로 내 정보 조회")
    @GetMapping("/userId/{userId}")
    public ResponseEntity<UserInfoResponse> getUserById(@ApiParam(value = "유저 ID") @PathVariable final Long userId,
                                                        @LoginUser SessionUser sessionUser){

        /*if(!Objects.equals(userId, sessionUser.getId()))
            throw new CustomException(BaseResponseStatus.SESSION_INCONSISTENCY);*/

        UserInfoResponse userInfoResponse = userService.getUserInfo(userId);

        return ResponseEntity.ok(userInfoResponse);
    }

    @ApiOperation("Email로 내 정보 조회")
    @GetMapping("/email/{email}")
    public ResponseEntity<UserInfoResponse> getUserByEmail(@ApiParam(value = "유저 이메일") @PathVariable final String email,
                                                           @LoginUser SessionUser sessionUser){

        /*if(!email.equals(sessionUser.getEmail()))
            throw new CustomException(BaseResponseStatus.SESSION_INCONSISTENCY);*/

        return ResponseEntity.ok(
                userService.getUserInfo(email)
        );
    }

    @ApiOperation("ID로 내 정보 수정")
    @PutMapping("/userId/{userId}")
    public ResponseEntity<UserInfoResponse> updateUserInfo(@ApiParam(value = "유저 ID") @PathVariable final Long userId,
                                                           @ApiParam(value = "변경된 정보가 포함된 유저 정보") @RequestBody UserUpdateRequest userUpdateRequest,
                                                           @LoginUser SessionUser loginUser){
        /*if(email.equals(loginUser.getEmail()))
            throw new CustomException(BaseResponseStatus.SESSION_INCONSISTENCY);*/

        return ResponseEntity.ok(
                userService.updateUserInfo(userId, userUpdateRequest)
        );
    }

    @ApiOperation("Email로 내 정보 수정")
    @PutMapping("/email/{email}")
    public ResponseEntity<UserInfoResponse> updateUserInfo(@ApiParam(value = "유저 이메일") @PathVariable final String email,
                                                           @ApiParam(value = "변경된 정보가 포함된 유저 정보") @RequestBody UserUpdateRequest userUpdateRequest,
                                                           @LoginUser SessionUser loginUser){
        /*if(email.equals(loginUser.getEmail()))
            throw new CustomException(BaseResponseStatus.SESSION_INCONSISTENCY);*/

        return ResponseEntity.ok(
                userService.updateUserInfo(email, userUpdateRequest)
        );
    }

    @ApiOperation("구인자 권한 습득")
    @PutMapping("/{userId}/role/recruiter")
    public ResponseEntity<UserInfoResponse> updateUserInfo(@ApiParam(value = "유저 ID") @PathVariable final Long userId,
                                                           @LoginUser SessionUser loginUser){
        /*if(email.equals(loginUser.getEmail()))
            throw new CustomException(BaseResponseStatus.SESSION_INCONSISTENCY);*/

        return ResponseEntity.ok(
                userService.changeUserRole(userId)
        );
    }


    @ApiOperation("공고에 지원한 지원자 리스트 조회")
    @GetMapping("/recruits/{recruitId}")
    public ResponseEntity<List<UserInfoResponse>> getAppliedUserList(@PathVariable final Long recruitId){
        ArrayList<UserInfoResponse> userList = new ArrayList<>();
        userList.add(UserInfoResponse.builder()
                .id(1L)
                .email("d@d")
                .name("leejoohee")
                .role(UserRole.USER)
                .profileImage("http://dfdfsdf")
                .build());
        return ResponseEntity.ok(userList);
    }

    @ApiOperation("내 비자 정보 등록")
    @PostMapping("/visa/{userId}")
    public ResponseEntity<Void> setMyVisa(@PathVariable final Long userId, @RequestBody @Valid UserVisaRequest userVisaRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("내 비자 정보 수정")
    @PutMapping("/visa/{userId}")
    public ResponseEntity<Void> deleteMyVisa(@PathVariable final Long userId, @RequestBody @Valid UserVisaUpdateRequest userVisaUpdateRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("내 비자 정보 조회")
    @GetMapping("/visa/{userId}")
    public ResponseEntity<Void> getMyVisa(@PathVariable final Long userId){
        return ResponseEntity.ok().build();
    }

}
