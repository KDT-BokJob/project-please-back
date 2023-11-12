package com.kdt.please.domain.company.service;

import com.kdt.please.domain.company.Company;
import com.kdt.please.domain.company.repository.CompanyRepository;
import com.kdt.please.domain.company.service.request.CompanyCreateRequest;
import com.kdt.please.domain.company.service.request.CompanyUpdateRequest;
import com.kdt.please.domain.company.service.response.CompanyResponse;
import com.kdt.please.domain.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@AllArgsConstructor
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;

    public CompanyResponse getCompany(Long companyId){
        return CompanyResponse.from(companyRepository.findById(companyId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 기업이 존재하지 않습니다.")));
    }

    public Long createCompany(CompanyCreateRequest companyCreateRequest){
        // 현재 유저가 구인자인지 확인

        Company company = companyCreateRequest.toEntity();
        company.setUser(userRepository.findById(companyCreateRequest.userId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 유저가 존재하지 않습니다.")));
        return companyRepository.save(company).getCompanyId();
    }

    public CompanyResponse updateCompany(Long companyId, CompanyUpdateRequest request){
//        수정하려는 유저랑 company user랑 같은지 확인
//        CompanyResponse company = getCompany(companyId);
//        if(company.userId() != sessionUser.getUserId())){
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,"수정할 권한이 없습니다.");
//        }
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 기업이 존재하지 않습니다."));
        company.changeCompany(request);
        return CompanyResponse.from(company);
    }

    public void deleteCompany(Long companyId){
        companyRepository.deleteById(companyId);
    }
}