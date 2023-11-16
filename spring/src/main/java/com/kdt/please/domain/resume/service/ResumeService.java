package com.kdt.please.domain.resume.service;

import com.kdt.please.domain.resume.Resume;
import com.kdt.please.domain.resume.repository.ResumeRepository;
import com.kdt.please.domain.resume.service.request.ResumeCreateRequest;
import com.kdt.please.domain.resume.service.request.ResumeDraftRequest;
import com.kdt.please.domain.resume.service.request.ResumeUpdateRequest;
import com.kdt.please.domain.resume.service.response.ResumeDraftResponse;
import com.kdt.please.domain.resume.service.response.ResumeResponse;
import com.kdt.please.domain.user.User;
import com.kdt.please.domain.user.repository.UserRepository;
import com.kdt.please.domain.userVisa.UserVisa;
import com.kdt.please.domain.userVisa.repository.UserVisaRepository;
import com.kdt.please.domain.visa.Visa;
import com.kdt.please.domain.visa.repository.VisaRepository;
import com.kdt.please.exception.BaseResponseStatus;
import com.kdt.please.exception.CustomException;
import com.kdt.please.global.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RequiredArgsConstructor
@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;
    private final UserVisaRepository userVisaRepository;
    private final VisaRepository visaRepository;
    private final S3Service s3Service;

    public Long createResume(Long userId, ResumeCreateRequest resumeCreateRequest, MultipartFile image, MultipartFile file) throws IOException {
        String imageUrl = "", fileUrl = "";
        if(image != null) {
            imageUrl = s3Service.saveFile(image);
        }
        if(file != null) {
            fileUrl = s3Service.saveFile(file);
        }
        Resume resume = resumeCreateRequest.toEntity();
        resume.setImage(imageUrl);
        resume.setResumeFile(fileUrl);
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        resume.setUser(user);
        Visa visa = visaRepository.findByVisa(resumeCreateRequest.visa())
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        // 유저 비자 저장
        userVisaRepository.save(UserVisa.builder()
                .user(user)
                .visa(visa)
                .build());
        // tags 저장
        if(resumeCreateRequest.tags() != null){
            String tags = listToString(resumeCreateRequest.tags());
            resume.setTag(tags);
        }
        // hopejobs 저장
        if(resumeCreateRequest.hopeJobs() != null){
            String hopeJobs = listToString(resumeCreateRequest.hopeJobs());
            resume.setHopeJob(hopeJobs);
        }
        resume.setIsCompleted(true);
        return resumeRepository.save(resume).getResumeId();
    }

    public Long createDraftResume(Long userId, ResumeDraftRequest resumeDraftRequest, MultipartFile image, MultipartFile file) throws IOException {
        String imageUrl = "", fileUrl = "";
        if(image != null) {
            imageUrl = s3Service.saveFile(image);
        }
        if(file != null) {
            fileUrl = s3Service.saveFile(file);
        }
        Resume resume = resumeDraftRequest.toEntity();
        resume.setImage(imageUrl);
        resume.setResumeFile(fileUrl);
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        resume.setUser(user);
        if(resumeDraftRequest.visa() != null) {
            Visa visa = visaRepository.findByVisa(resumeDraftRequest.visa())
                    .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
            // 유저 비자 저장
            userVisaRepository.save(UserVisa.builder()
                    .user(user)
                    .visa(visa)
                    .build());
        }
        // tags 저장
        if(resumeDraftRequest.tags() != null){
            String tags = listToString(resumeDraftRequest.tags());
            resume.setTag(tags);
        }
        // hopejobs 저장
        if(resumeDraftRequest.hopeJobs() != null){
            String hopeJobs = listToString(resumeDraftRequest.hopeJobs());
            resume.setHopeJob(hopeJobs);
        }
        resume.setIsCompleted(false);
        return resumeRepository.save(resume).getResumeId();
    }

    public ResumeResponse getResumeInfo(Long resumeId){
        // 자기가 쓴 resume 맞는지 확인 (나중에 수정)

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));

        List<String> tagList = new ArrayList<>(), hopeJobList = new ArrayList<>();
        // 태그 배열형으로
        if(resume.isTagExist()){
            tagList = stringToList(resume.getTag());
        }
        // 비자
        String visa = userVisaRepository.findVisaByUserId(resume.getUser().getUserId())
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        // 희망직종
        if(resume.isHopeJobExist()){
            hopeJobList = stringToList(resume.getHopeJob());
        }
        return ResumeResponse.from(resume, tagList, hopeJobList, visa);
    }

    public ResumeDraftResponse getDraftResume(Long userId){
        Optional<Resume> resumeOptional = resumeRepository.findByUserId(userId);
        if(resumeOptional.isEmpty() || resumeOptional.get().getIsCompleted()){
            return null;
        }
        Resume resume = resumeOptional.get();
        List<String> tagList = new ArrayList<>(), hopeJobList = new ArrayList<>();
        // 태그 배열형으로
        if(resume.isTagExist()){
            tagList = stringToList(resume.getTag());
        }
        // 비자
        Optional<String> visa = userVisaRepository.findVisaByUserId(resume.getUser().getUserId());
        // 희망직종
        if(resume.isHopeJobExist()){
            hopeJobList = stringToList(resume.getHopeJob());
        }
        return ResumeDraftResponse.from(resume, tagList, hopeJobList, visa.orElse(null));
    }

    public ResumeResponse updateResume(Long resumeId, ResumeUpdateRequest resumeUpdateRequest, MultipartFile image, MultipartFile file) throws IOException {
        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        resume.change(resumeUpdateRequest);
        // tags
        if(resumeUpdateRequest.tags() != null){
            String tags = listToString(resumeUpdateRequest.tags());
            resume.setTag(tags);
        }
        // hopejobs
        if(resumeUpdateRequest.hopeJobs() != null) {
            String hopeJobs = listToString(resumeUpdateRequest.hopeJobs());
            resume.setHopeJob(hopeJobs);
        }
        // visa
        User user = userRepository.findById(resume.getUser().getUserId())
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        userVisaRepository.deleteByUserId(user.getUserId());
        Visa visa = visaRepository.findByVisa(resumeUpdateRequest.visa())
                .orElseThrow(() -> new CustomException(BaseResponseStatus.DATA_NOT_FOUND));
        userVisaRepository.save(UserVisa.builder()
                .user(user)
                .visa(visa)
                .build());
        String imageUrl = "", fileUrl = "";
        if(image != null) {
            imageUrl = s3Service.saveFile(image);
        }
        if(file != null) {
            fileUrl = s3Service.saveFile(file);
        }
        resume.setImage(imageUrl);
        resume.setResumeFile(fileUrl);
        return ResumeResponse.from(resume, resumeUpdateRequest.tags(), resumeUpdateRequest.hopeJobs(), resumeUpdateRequest.visa());
    }

    public void deleteResume(Long resumeId){
        resumeRepository.deleteById(resumeId);
    }

    private static String listToString(List<String> array) {
        StringJoiner joiner = new StringJoiner(",");
        for (String value : array) {
            joiner.add(value);
        }
        return joiner.toString();
    }

    private static List<String> stringToList(String string){
        return Arrays.asList(string.split(","));
    }
}