package com.kdt.please.domain.user.controller;

import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.UserRole;
import com.kdt.please.domain.user.repository.UserRepository;
import com.kdt.please.domain.user.service.request.UserInfoRequest;
import com.kdt.please.domain.user.service.request.UserUpdateRequest;
import com.kdt.please.domain.user.service.response.UserInfoResponse;
import com.kdt.please.domain.userVisa.dto.UserVisaRequest;
import com.kdt.please.domain.userVisa.dto.UserVisaUpdateRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ApiOperation("회원가입 추가정보 입력 (구직자)")
    @PostMapping("/{userId}")
    public ResponseEntity<Void> createUserInfo(@PathVariable final Long userId, @RequestBody @Valid UserInfoRequest userInfoRequest){
        return ResponseEntity.ok().build();
    }

    @ApiOperation("내 정보 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable final Long userId){
        Optional<User> user = userRepository.findByUserId(userId);

        return user.map(value -> ResponseEntity.ok(UserInfoResponse.builder()
                .email(value.getEmail())
                .name(value.getName())
                .profileImage(value.getProfileImage())
                .role(value.getRole()).build())).orElseThrow(RuntimeException::new);
    }

    @ApiOperation("내 정보 수정")
    @PutMapping("/{userId}")
    public ResponseEntity<UserInfoResponse> updateUserInfo(@PathVariable final Long userId, @RequestBody UserUpdateRequest userUpdateRequest){
        Optional<User> loginUser = userRepository.findByUserId(userId);

        if(loginUser.isEmpty())
            throw new RuntimeException();

        User user = userRepository.save(User.builder()
                .userId(userId)
                .email(loginUser.get().getEmail())
                .name(userUpdateRequest.name())
                .profileImage(userUpdateRequest.profileImage())
                .role(loginUser.get().getRole()).build());

        return ResponseEntity.ok(
                UserInfoResponse.builder()
                        .id(user.getUserId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .profileImage(user.getProfileImage())
                        .role(user.getRole())
                        .build()
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
