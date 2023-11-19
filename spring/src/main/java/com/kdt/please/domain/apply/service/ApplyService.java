package com.kdt.please.domain.apply.service;

import com.kdt.please.domain.apply.Apply;
import com.kdt.please.domain.apply.repository.ApplyRepository;
import com.kdt.please.domain.apply.service.request.ApplyCreateRequest;
import com.kdt.please.domain.apply.service.response.ApplyResponse;
import com.kdt.please.domain.apply.service.response.RecruitApplyListResponse;
import com.kdt.please.domain.apply.service.response.UserApplyListResponse;
import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.recruit.repository.RecruitRepository;
import com.kdt.please.domain.resume.repository.ResumeRepository;
import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.repository.UserRepository;
import com.kdt.please.exception.BaseResponseStatus;
import com.kdt.please.exception.CustomException;
import com.kdt.please.global.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplyService {

    private final ApplyRepository applyRepository;
    private final UserRepository userRepository;
    private final RecruitRepository recruitRepository;
    private final ResumeRepository resumeRepository;

    @Autowired
    public ApplyService(ApplyRepository applyRepository, UserRepository userRepository, RecruitRepository recruitRepository, ResumeRepository resumeRepository){
        this.applyRepository = applyRepository;
        this.userRepository = userRepository;
        this.recruitRepository = recruitRepository;
        this.resumeRepository = resumeRepository;
    }

    // 지원 내역 리스트 조회
    public List<RecruitApplyListResponse> getApplyListByUserId(Long userId, Pageable pageable){
        Page<Apply> applyPage = applyRepository.findAllByUser_UserId(userId, pageable);
        List<Apply> applyList = applyPage.stream().toList();

        return applyList.stream()
                .map(value -> RecruitApplyListResponse.from(value.getRecruit(), value.getApplyId()))
                .toList();
    }

    public List<UserApplyListResponse> getApplyListByRecruitId(Long recruitId, Pageable pageable){
        Page<Apply> applyPage = applyRepository.findAllByRecruit_RecruitId(recruitId, pageable);
        List<Apply> applyList = applyPage.stream().toList();

        return applyList.stream()
                .map(value -> UserApplyListResponse
                        .from(
                            resumeRepository.findById(value.getResumeId())
                                    .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND)),
                            value.getApplyId()
                        )
                ).toList();
    }

    // 지원 내역 정보 등록
    public ApplyResponse createApply(Long recruitId, ApplyCreateRequest applyCreateRequest) {
        User user = userRepository.findByUserId(applyCreateRequest.userId()).orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        Recruit recruit = recruitRepository.findById(recruitId).orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));

        resumeRepository.findById(applyCreateRequest.resumeId()).orElseThrow(() -> new CustomException(BaseResponseStatus.RESUME_NOT_COMPLETE));

        return applyRepository.findByRecruit_RecruitId(recruitId).map(value -> ApplyResponse.from(
                applyRepository.save(Apply.builder()
                        .applyId(value.getApplyId())
                        .user(user)
                        .recruit(recruit)
                        .resumeId(applyCreateRequest.resumeId())
                        .status(Status.APPLIED)
                        .build()
                )
        )).orElseThrow(() -> new CustomException(BaseResponseStatus.MODIFY_FAIL_APPLY));
    }

    // 지원 내역 상태 수정
    public ApplyResponse updateApply(Long applyId, Status status){
        return applyRepository.findById(applyId).map(value -> ApplyResponse.from(
                applyRepository.save(Apply.builder()
                        .applyId(value.getApplyId())
                        .user(value.getUser())
                        .recruit(value.getRecruit())
                        .resumeId(value.getResumeId())
                        .status(status)
                        .build()
                )
        )).orElseThrow(() -> new CustomException(BaseResponseStatus.MODIFY_FAIL_APPLY));
    }

    // 지원 상세 조회
    public ApplyResponse getApply(Long recruitId, Long userId){
        return applyRepository.findByRecruit_RecruitIdAndUser_UserId(recruitId, userId)
                .map(ApplyResponse::from)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
    }

    public ApplyResponse getApply(Long applyId){
        return ApplyResponse.from(
                applyRepository.findById(applyId)
                        .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND))
        );
    }
}