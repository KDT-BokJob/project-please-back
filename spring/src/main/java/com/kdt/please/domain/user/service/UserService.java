package com.kdt.please.domain.user.service;

import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.UserRole;
import com.kdt.please.domain.user.repository.UserRepository;
import com.kdt.please.domain.user.service.request.UserUpdateRequest;
import com.kdt.please.domain.user.service.response.UserInfoResponse;
import com.kdt.please.exception.BaseResponseStatus;
import com.kdt.please.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 정보 조회
    public UserInfoResponse getUserInfo(Long userId){
        return userRepository.findByUserId(userId).map(value -> UserInfoResponse.builder()
                .id(value.getUserId())
                .email(value.getEmail())
                .name(value.getName())
                .profileImage(value.getProfileImage())
                .role(value.getRole())
                .build()
        ).orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
    }

    public UserInfoResponse getUserInfo(String email){
        return userRepository.findByEmail(email).map(value -> UserInfoResponse.builder()
                .id(value.getUserId())
                .email(value.getEmail())
                .name(value.getName())
                .profileImage(value.getProfileImage())
                .role(value.getRole())
                .build()
        ).orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
    }

    // 유저 정보 수정
    @Transactional
    public UserInfoResponse updateUserInfo(Long userId, UserUpdateRequest request){
        return userRepository.findByUserId(userId).map(value -> UserInfoResponse.toEntity(
                        userRepository.save(User.builder()
                                .userId(value.getUserId())
                                .email(value.getEmail())
                                .name(request.name())
                                .profileImage(request.profileImage())
                                .role(value.getRole())
                                .build())
                )
        ).orElseThrow(() -> new CustomException(BaseResponseStatus.MODIFY_FAIL_USER));
    }

    @Transactional
    public UserInfoResponse updateUserInfo(String email, UserUpdateRequest request){
        return userRepository.findByEmail(email).map(value -> UserInfoResponse.toEntity(
                userRepository.save(User.builder()
                        .userId(value.getUserId())
                        .email(value.getEmail())
                        .name(request.name())
                        .profileImage(request.profileImage())
                        .role(value.getRole())
                        .build())
                )
        ).orElseThrow(() -> new CustomException(BaseResponseStatus.MODIFY_FAIL_USER));
    }

    // 유저 권한 Recruiter 변경
    @Transactional
    public UserInfoResponse changeUserRole(Long userId){
        Optional<User> user = Optional.ofNullable(userRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.NULLPOINTER_EXCEPTION)));

        return userRepository.findByUserId(userId).map(value -> UserInfoResponse.toEntity(
                userRepository.save(User.builder()
                        .userId(user.get().getUserId())
                        .email(user.get().getEmail())
                        .name(user.get().getName())
                        .profileImage(user.get().getProfileImage())
                        .role(UserRole.RECRUITER)
                        .build())
                )
        ).orElseThrow(() -> new CustomException(BaseResponseStatus.MODIFY_FAIL_USER));
    }
}
