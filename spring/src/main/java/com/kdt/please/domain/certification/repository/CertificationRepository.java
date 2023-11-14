package com.kdt.please.domain.certification.repository;

import com.kdt.please.domain.certification.Certification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
