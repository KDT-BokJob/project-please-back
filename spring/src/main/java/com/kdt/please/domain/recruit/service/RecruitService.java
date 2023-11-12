package com.kdt.please.domain.recruit.service;

import com.kdt.please.domain.company.repository.CompanyRepository;
import com.kdt.please.domain.filter.JobService;
import com.kdt.please.domain.filter.VisaFilter;
import com.kdt.please.domain.filter.VisaFilterRepository;
import com.kdt.please.domain.recruit.Recruit;
import com.kdt.please.domain.recruit.repository.RecruitRepository;
import com.kdt.please.domain.recruit.service.request.RecruitCreateRequest;
import com.kdt.please.domain.recruit.service.request.RecruitUpdateRequest;
import com.kdt.please.domain.recruit.service.response.RecruitResponse;
import com.kdt.please.domain.recruit.service.response.RecruitSimpleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class RecruitService {

    private final RecruitRepository recruitRepository;
    private final CompanyRepository companyRepository;
    private final VisaFilterRepository visaFilterRepository;
    private final JobService jobService;

    public Long createRecruit(RecruitCreateRequest recruitCreateRequest){
        Recruit recruit = recruitCreateRequest.toEntity();
        recruit.setCompany(companyRepository.findById(recruitCreateRequest.companyId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 기업이 존재하지 않습니다.")));
        return recruitRepository.save(recruit).getRecruitId();
    }

    public RecruitResponse getRecruit(Long recruitId){
        Recruit recruit = recruitRepository.findById(recruitId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 공고가 존재하지 않습니다."));

        return RecruitResponse.from(recruit, findVisaList(recruit.getJobCode().getJobCode()));
    }

    public RecruitResponse updateRecruit(Long recruitId, RecruitUpdateRequest recruitUpdateRequest){
        Recruit recruit = recruitRepository.findById(recruitId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 공고가 존재하지 않습니다."));
        recruit.changeRecruit(recruitUpdateRequest.toEntity());
        recruit.setJobCode(jobService.getJobCodeByJobName(recruitUpdateRequest.jobName()));
        return RecruitResponse.from(recruit, findVisaList(recruit.getJobCode().getJobCode()));
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