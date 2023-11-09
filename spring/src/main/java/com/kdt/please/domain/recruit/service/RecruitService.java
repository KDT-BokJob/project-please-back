package com.kdt.please.domain.recruit.service;

import com.kdt.please.domain.company.repository.CompanyRepository;
import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.recruit.repository.RecruitRepository;
import com.kdt.please.domain.recruit.service.request.RecruitCreateRequest;
import com.kdt.please.domain.recruit.service.response.RecruitResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class RecruitService {

    private final RecruitRepository recruitRepository;
    private final CompanyRepository companyRepository;

    public Long createPost(RecruitCreateRequest recruitCreateRequest){
        Recruit recruit = recruitCreateRequest.toEntity();
        recruit.setCompany(companyRepository.findById(recruitCreateRequest.companyId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 기업이 존재하지 않습니다.")));
        return recruitRepository.save(recruit).getRecruitId();
    }

    public RecruitResponse getPost(Long postId){
        Recruit recruit = recruitRepository.findById(postId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 공고가 존재하지 않습니다."));
        return RecruitResponse.from(recruit);
    }

    public void deletePost(Long postId){
        recruitRepository.deleteById(postId);
    }

}
