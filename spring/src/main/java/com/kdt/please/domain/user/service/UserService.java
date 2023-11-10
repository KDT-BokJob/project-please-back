package com.kdt.please.domain.user.service;

import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.UserRole;
import com.kdt.please.domain.user.repository.UserRepository;
import com.kdt.please.domain.user.service.request.UserUpdateRequest;
import com.kdt.please.domain.user.service.response.UserInfoResponse;
import com.kdt.please.domain.userVisa.UserVisa;
import com.kdt.please.domain.userVisa.repository.UserVisaRepository;
import com.kdt.please.domain.userVisa.service.request.UserVisaRequest;
import com.kdt.please.domain.userVisa.service.request.UserVisaUpdateRequest;
import com.kdt.please.domain.userVisa.service.response.UserVisaInfoResponse;
import com.kdt.please.domain.visa.Visa;
import com.kdt.please.domain.visa.repository.VisaRepository;
import com.kdt.please.domain.visa.response.VisaInfoResponse;
import com.kdt.please.exception.BaseResponseStatus;
import com.kdt.please.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final VisaRepository visaRepository;
    private final UserVisaRepository userVisaRepository;
    @Autowired
    public UserService(UserRepository userRepository, VisaRepository visaRepository, UserVisaRepository userVisaRepository) {
        this.userRepository = userRepository;
        this.visaRepository = visaRepository;
        this.userVisaRepository = userVisaRepository;
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
        return userRepository.findByUserId(userId).map(value -> UserInfoResponse.toEntity(
                userRepository.save(User.builder()
                        .userId(value.getUserId())
                        .email(value.getEmail())
                        .name(value.getName())
                        .profileImage(value.getProfileImage())
                        .role(UserRole.RECRUITER)
                        .build())
                )
        ).orElseThrow(() -> new CustomException(BaseResponseStatus.MODIFY_FAIL_USER));
    }

    // 유저 비자 정보 조회
    public UserVisaInfoResponse getUserVisaInfo(Long userId){
        return userVisaRepository.findById(userId).map(value -> UserVisaInfoResponse.builder()
                .id(value.getId())
                .visa(value.getVisa())
                .createdAt(value.getCreatedAt())
                .expiredAt(value.getExpiredAt())
                .build()
        ).orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
    }

    // 유저 비자에 해당 하는 비자 정보 조회
    public VisaInfoResponse getVisaInfo(String visa){
        return visaRepository.findById(visa).map(value -> VisaInfoResponse.builder()
                .visa(value.getVisa())
                .validityPeriod(value.getValidityPeriod())
                .build()
        ).orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
    }

    // 유저 비자 정보 등록
    @Transactional
    public UserVisaInfoResponse createUserVisa(Long userId, UserVisaRequest request){
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        Visa visa = visaRepository.findById(request.visa()).orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));

        return UserVisaInfoResponse.toEntity(
            userVisaRepository.save(UserVisa.builder()
                    .user(user)
                    .visa(visa)
                    .createdAt(request.created_at())
                    .expiredAt(request.created_at().plusMonths(visa.getValidityPeriod()))
                    .build()
            )
        );
    }

    // 유저 비자 정보 수정
    @Transactional
    public UserVisaInfoResponse updateUserVisa(Long userId, UserVisaUpdateRequest request){
        Visa visa = visaRepository.findById(request.visa()).orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));

        return userVisaRepository.findByUser_UserId(userId).map(value -> UserVisaInfoResponse.toEntity(
                userVisaRepository.save(UserVisa.builder()
                        .id(value.getId())
                        .user(value.getUser())
                        .visa(visa)
                        .createdAt(request.created_at())
                        .expiredAt(request.created_at().plusMonths(visa.getValidityPeriod()))
                        .build()
                )
        )).orElseThrow(() -> new CustomException(BaseResponseStatus.MODIFY_FAIL_USERVISA));
    }

    // 유저 비자 정보 삭제
    @Transactional
    public void deleteUserVisaInfo(Long userId){
        userVisaRepository.deleteByUser_UserId(userId);
    }
}
