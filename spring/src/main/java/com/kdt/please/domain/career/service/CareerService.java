package com.kdt.please.domain.career.service;

import com.kdt.please.domain.career.Career;
import com.kdt.please.domain.career.repository.CareerRepository;
import com.kdt.please.domain.career.service.request.CareerCreateRequest;
import com.kdt.please.domain.career.service.request.CareerUpdateRequest;
import com.kdt.please.domain.career.service.response.CareerInfoResponse;
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
public class CareerService {
    private final CareerRepository careerRepository;
    private final ResumeRepository resumeRepository;

    public Long createCareer(CareerCreateRequest careerCreateRequest){
        Career career = careerCreateRequest.toEntity();
        Resume resume = resumeRepository.findById(careerCreateRequest.resumeId())
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        career.setResume(resume);
        return careerRepository.save(career).getCareerId();
    }

    public CareerInfoResponse getCareerInfo(Long careerId){
        return CareerInfoResponse.from(careerRepository.findById(careerId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND)));
    }

    public List<CareerInfoResponse> getMyCareersByResumeId(Long resumeId){
        return careerRepository.findByResumeId(resumeId).stream()
                .map(c -> CareerInfoResponse.from(c)).collect(Collectors.toList());
    }

    public CareerInfoResponse updateCareer(Long careerId, CareerUpdateRequest careerUpdateRequest){
        Career career = careerRepository.findById(careerId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        career.change(careerUpdateRequest);
        return CareerInfoResponse.from(career);
    }

    public void deleteCareer(Long careerId){
        Career career = careerRepository.findById(careerId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        careerRepository.delete(career);
    }
}
