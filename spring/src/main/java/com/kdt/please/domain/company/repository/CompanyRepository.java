package com.kdt.please.domain.company.repository;

import com.kdt.please.domain.company.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
