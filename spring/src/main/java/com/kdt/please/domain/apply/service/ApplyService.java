package com.kdt.please.domain.apply.service;

import com.kdt.please.domain.apply.Apply;
import com.kdt.please.domain.apply.repository.ApplyRepository;
import com.kdt.please.domain.apply.service.response.ApplyResponse;
import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.recruit.service.response.RecruitSimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplyService {

    private final ApplyRepository applyRepository;

    @Autowired
    public ApplyService(ApplyRepository applyRepository){
        this.applyRepository = applyRepository;
    }

    // 지원 내역 리스트 조회
    public List<ApplyResponse> getApplyList(Long userId, Pageable pageable){
        Page<Apply> applyPage = applyRepository.findAllByUser_UserId(userId, pageable);
        List<Apply> applyList = applyPage.stream().collect(Collectors.toList());
        return ApplyResponse.from(applyList);
    }
}
