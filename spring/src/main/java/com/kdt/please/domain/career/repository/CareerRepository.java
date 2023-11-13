package com.kdt.please.domain.career.repository;

import com.kdt.please.domain.career.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
