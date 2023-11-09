package com.kdt.please.domain.user.controller;

import com.kdt.please.config.auth.LoginUser;
import com.kdt.please.config.auth.dto.SessionUser;
import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.UserRole;
import com.kdt.please.domain.user.repository.UserRepository;
import com.kdt.please.domain.user.service.request.UserInfoRequest;
import com.kdt.please.domain.user.service.request.UserUpdateRequest;
import com.kdt.please.domain.user.service.response.UserInfoResponse;
import com.kdt.please.domain.userVisa.dto.UserVisaRequest;
import com.kdt.please.domain.userVisa.dto.UserVisaUpdateRequest;
import com.kdt.please.exception.BaseResponseStatus;
import com.kdt.please.exception.CustomException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ApiOperation("ID로 내 정보 조회")
    @GetMapping("/id/{userId}")
    public ResponseEntity<UserInfoResponse> getUserById(@PathVariable final Long userId, @LoginUser SessionUser sessionUser){

        /*if(!Objects.equals(userId, sessionUser.getId()))
            throw new CustomException(BaseResponseStatus.SESSION_INCONSISTENCY);*/

        Optional<User> user = userRepository.findByUserId(userId);

        return user.map(value -> ResponseEntity.ok(UserInfoResponse.builder()
                .id(value.getUserId())
                .email(value.getEmail())
                .name(value.getName())
                .profileImage(value.getProfileImage())
                .role(value.getRole()).build())).orElseThrow(RuntimeException::new);
    }

    @ApiOperation("Email로 내 정보 조회")
    @GetMapping("/email/{email}")
    public ResponseEntity<UserInfoResponse> getUserByEmail(@PathVariable final String email, @LoginUser SessionUser sessionUser){

        /*if(!email.equals(sessionUser.getEmail()))
            throw new CustomException(BaseResponseStatus.SESSION_INCONSISTENCY);*/

        Optional<User> user = userRepository.findByEmail(email);

        return user.map(value -> ResponseEntity.ok(UserInfoResponse.builder()
                .id(value.getUserId())
                .email(value.getEmail())
                .name(value.getName())
                .profileImage(value.getProfileImage())
                .role(value.getRole()).build())).orElseThrow(RuntimeException::new);
    }

    @ApiOperation("내 정보 수정")
    @PutMapping("/email/{email}")
    public ResponseEntity<UserInfoResponse> updateUserInfo(@PathVariable final String email,
                                                           @RequestBody UserUpdateRequest userUpdateRequest,
                                                           @LoginUser SessionUser loginUser){
        /*if(email.equals(loginUser.getEmail()))
            throw new CustomException(BaseResponseStatus.SESSION_INCONSISTENCY);*/

        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty())
            throw new CustomException(BaseResponseStatus.NULLPOINTER_EXCEPTION);

        User userTemp = userRepository.save(User.builder()
                .userId(user.get().getUserId())
                .email(user.get().getEmail())
                .name(userUpdateRequest.name())
                .profileImage(userUpdateRequest.profileImage())
                .role(user.get().getRole()).build());

        return ResponseEntity.ok(
                UserInfoResponse.toEntity(userTemp)
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
