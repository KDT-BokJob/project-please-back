package com.kdt.please.domain.resume.service;

import com.kdt.please.domain.resume.repository.ResumeRepository;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }
}
