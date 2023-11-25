package com.kdt.please.domain.visa.repository;

import com.kdt.please.domain.visa.Visa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VisaRepository extends JpaRepository<Visa, String> {

    Optional<Visa> findByVisa(String visa);
}