package com.kdt.please.domain.recruit.service;

import com.kdt.please.domain.apply.repository.ApplyRepository;
import com.kdt.please.domain.company.repository.CompanyRepository;
import com.kdt.please.domain.filter.JobService;
import com.kdt.please.domain.filter.VisaFilter;
import com.kdt.please.domain.filter.VisaFilterRepository;
import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.recruit.repository.RecruitRepository;
import com.kdt.please.domain.recruit.service.request.RecruitCreateRequest;
import com.kdt.please.domain.recruit.service.request.RecruitUpdateRequest;
import com.kdt.please.domain.recruit.service.response.RecruitApplyResponse;
import com.kdt.please.domain.recruit.service.response.RecruitResponse;
import com.kdt.please.domain.recruit.service.response.RecruitSimpleResponse;
import com.kdt.please.domain.recruitTag.RecruitTag;
import com.kdt.please.domain.recruitTag.RecruitTagMap;
import com.kdt.please.domain.recruitTag.repository.RecruitTagMapRepository;
import com.kdt.please.domain.recruitTag.repository.RecruitTagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class RecruitService {

    private final RecruitRepository recruitRepository;
    private final ApplyRepository applyRepository;
    private final CompanyRepository companyRepository;
    private final VisaFilterRepository visaFilterRepository;
    private final RecruitTagRepository recruitTagRepository;
    private final RecruitTagMapRepository recruitTagMapRepository;
    private final JobService jobService;

    public Long createRecruit(RecruitCreateRequest recruitCreateRequest){
        Recruit recruit = recruitCreateRequest.toEntity();
        recruit.setCompany(companyRepository.findById(recruitCreateRequest.companyId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 기업이 존재하지 않습니다.")));
        recruit.setJobCode(jobService.getJobCodeByJobName(recruitCreateRequest.jobName()));
        recruitRepository.save(recruit);
        // 태그 추가
        HashSet<RecruitTagMap> recruitTagMaps = new HashSet<>();
        List<String> tagNames = recruitCreateRequest.tags();
        for (String tagName: tagNames) {
            // 태그 찾고 없으면 생성
            RecruitTag recruitTag = recruitTagRepository.findByName(tagName).orElseGet(() ->
                    recruitTagRepository.save(RecruitTag.builder()
                            .name(tagName).build()));
            RecruitTagMap recruitTagMap = RecruitTagMap.builder()
                    .recruit(recruit)
                    .tag(recruitTag)
                    .build();
            if(recruitTagMapRepository.findByRecruitAndTag(recruit.getRecruitId(), recruitTag.getTagId()).isEmpty()){
                recruitTagMapRepository.save(recruitTagMap);
            }
        }

        return recruit.getRecruitId();
    }

    public RecruitResponse getRecruit(Long recruitId){
        Recruit recruit = recruitRepository.findById(recruitId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 공고가 존재하지 않습니다."));
        List<String> tagNames = new ArrayList<>();
        for (RecruitTagMap recruitTagMap: recruit.getTags()) {
            tagNames.add(recruitTagMap.getTag().getName());
        }
        return RecruitResponse.from(recruit, findVisaList(recruit.getJobCode().getJobCode()), tagNames);
    }

    public RecruitResponse updateRecruit(Long recruitId, RecruitUpdateRequest recruitUpdateRequest){
        Recruit recruit = recruitRepository.findById(recruitId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 공고가 존재하지 않습니다."));

        recruit.changeRecruit(recruitUpdateRequest);
        recruit.setJobCode(jobService.getJobCodeByJobName(recruitUpdateRequest.jobName()));
        recruitTagMapRepository.deleteByRecruit(recruitId);
        recruitRepository.save(recruit);

        List<String> tagNames = recruitUpdateRequest.tags();
        for (String tagName: tagNames) {
            // 태그 찾고 없으면 생성
            RecruitTag recruitTag = recruitTagRepository.findByName(tagName).orElseGet(() ->
                    recruitTagRepository.save(RecruitTag.builder()
                            .name(tagName).build()));
            RecruitTagMap recruitTagMap = RecruitTagMap.builder()
                    .recruit(recruit)
                    .tag(recruitTag)
                    .build();
            if(recruitTagMapRepository.findByRecruitAndTag(recruit.getRecruitId(), recruitTag.getTagId()).isEmpty()){
                recruitTagMapRepository.save(recruitTagMap);
            }
        }
        return RecruitResponse.from(recruit, findVisaList(recruit.getJobCode().getJobCode()), tagNames);
    }

    public void deleteRecruit(Long recruitId){
        recruitRepository.deleteById(recruitId);
    }

    public List<RecruitSimpleResponse> getRecruitList(Pageable pageable){
        Page<Recruit> recruitPage = recruitRepository.findAll(pageable);
        List<Recruit> recruitList = recruitPage.stream().collect(Collectors.toList());
        List<RecruitSimpleResponse> list = new ArrayList<>();
        for (Recruit recruit : recruitList) {
            list.add(RecruitSimpleResponse.from(recruit, findVisaList(recruit.getJobCode().getJobCode())));
        }
        return list;
    }

    public List<RecruitSimpleResponse> getRecruitListByCompany(Long companyId){
        List<Recruit> recruitList = recruitRepository.findByCompany(companyId);
        List<RecruitSimpleResponse> list = new ArrayList<>();
        for (Recruit recruit : recruitList) {
            list.add(RecruitSimpleResponse.from(recruit, findVisaList(recruit.getJobCode().getJobCode())));
        }
        return list;
    }

    public List<RecruitApplyResponse> getRecruitListByRecruiter(Long userId){
        List<Recruit> recruitList = recruitRepository.findByRecruiterId(userId);
        return recruitList.stream()
                .map(r -> RecruitApplyResponse.from(r,
                        findVisaList(r.getJobCode().getJobCode()),
                        applyRepository.getApplicantCountByRecruitId(r.getRecruitId())))
                .collect(Collectors.toList());
    }

    public List<RecruitSimpleResponse> searchByKeyword(String keyword){
        List<Recruit> recruitList = recruitRepository.findByKeyword(keyword);
        List<RecruitSimpleResponse> list = new ArrayList<>();
        for (Recruit recruit : recruitList) {
            list.add(RecruitSimpleResponse.from(recruit, findVisaList(recruit.getJobCode().getJobCode())));
        }
        return list;
    }

    public List<String> findVisaList(String jobCode){
        List<VisaFilter> visaFilters = visaFilterRepository.findByVisaFilterIdJobCode(jobCode);
        List<String> visaList = new ArrayList<>();
        for (VisaFilter visaFilter: visaFilters) {
            visaList.add(visaFilter.getId().getVisa().getVisa());
        }
        return visaList;
    }

}