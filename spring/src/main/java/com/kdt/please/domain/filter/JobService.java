package com.kdt.please.domain.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class JobService {
    private final JobCodeRepository jobCodeRepository;
    private final VisaFilterRepository visaFilterRepository;

    public List<String> getJobNameList(String keyword){
        return jobCodeRepository.findJobNameByKeyword(keyword);
    }

    public JobCode getJobCodeByJobName(String jobName){
        JobCode jobCode = jobCodeRepository.findJobCodeByJobName(jobName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 업종코드가 존재하지 않습니다."));
        return jobCode;
    }

    public List<String> getJobNamesByVisa(String visa){
        return jobCodeRepository.findJobNamesByVisa(visa);
    }

    public List<String> getVisaList(String keyword){
        // 업종명으로 업종코드 찾기
        List<String> jobCodes = jobCodeRepository.findJobCodeByKeyword(keyword);
        // 업종코드로 비자리스트 찾기
        return visaFilterRepository.findByVisaFilterIdJobCodes(jobCodes);
    }

}