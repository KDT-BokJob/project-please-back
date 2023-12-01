package com.kdt.please.domain.certification.repository;

import com.kdt.please.domain.certification.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
    @Query(value = "select * from certification c join resume r where c.resume_id=r.resume_id and r.resume_id=:resumeId", nativeQuery = true)
    List<Certification> findByResumeId(@Param("resumeId") Long resumeId);
}
