package com.kdt.please.domain.company.service;

import com.kdt.please.domain.company.Company;
import com.kdt.please.domain.company.repository.CompanyRepository;
import com.kdt.please.domain.company.service.request.CompanyCreateRequest;
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
        Company company = companyCreateRequest.toEntity();
        company.setUser(userRepository.findById(companyCreateRequest.userId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"해당 유저가 존재하지 않습니다.")));
        return companyRepository.save(company).getCompanyId();
    }

    public void deleteCompany(Long companyId){
        companyRepository.deleteById(companyId);
    }
}