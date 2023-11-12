package com.kdt.please.domain.apply.repository;

import com.kdt.please.domain.apply.Apply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Apply, Long> {
    Page<Apply> findAllByUser_UserId(Long userId, Pageable pageable);
}
