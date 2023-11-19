package com.kdt.please.domain.certification.service;

import com.kdt.please.domain.career.service.request.CareerUpdateRequest;
import com.kdt.please.domain.career.service.response.CareerInfoResponse;
import com.kdt.please.domain.certification.Certification;
import com.kdt.please.domain.certification.repository.CertificationRepository;
import com.kdt.please.domain.certification.service.request.CertificationCreateRequest;
import com.kdt.please.domain.certification.service.request.CertificationUpdateRequest;
import com.kdt.please.domain.certification.service.response.CertificationResponse;
import com.kdt.please.domain.resume.Resume;
import com.kdt.please.domain.resume.repository.ResumeRepository;
import com.kdt.please.exception.BaseResponseStatus;
import com.kdt.please.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CertificationService {
    private final CertificationRepository certificationRepository;
    private final ResumeRepository resumeRepository;

    public Long createCert(CertificationCreateRequest certificationCreateRequest){
        Certification certification = certificationCreateRequest.toEntity();
        Resume resume = resumeRepository.findById(certificationCreateRequest.resumeId())
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        certification.setResume(resume);
        return certificationRepository.save(certification).getCertificationId();
    }

    public CertificationResponse getCertInfo(Long certId){
        return CertificationResponse.from(certificationRepository.findById(certId)
                .orElseThrow(()-> new CustomException(BaseResponseStatus.DATA_NOT_FOUND)));
    }

    public List<CertificationResponse> getMyCerts(Long resumeId){
        return certificationRepository.findByResumeId(resumeId).stream()
                .map(c -> CertificationResponse.from(c)).collect(Collectors.toList());
    }

    public CertificationResponse updateCert(Long certId, CertificationUpdateRequest request){
        Certification certification = certificationRepository.findById(certId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        certification.change(request);
        return CertificationResponse.from(certification);
    }

    public void deleteCert(Long certId){
        Certification certification = certificationRepository.findById(certId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        certificationRepository.delete(certification);
    }
}
