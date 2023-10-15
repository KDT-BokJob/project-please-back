package com.kdt.please.domain.apply.repository;

import com.kdt.please.domain.recruit.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Recruit, Long> {
}
