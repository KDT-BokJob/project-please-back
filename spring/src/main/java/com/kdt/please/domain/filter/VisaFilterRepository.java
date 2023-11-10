package com.kdt.please.domain.filter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisaFilterRepository extends JpaRepository<VisaFilter, VisaFilterId> {
    @Query("select vf from VisaFilter vf where vf.id.jobCode.jobCode=:jobCode")
    List<VisaFilter> findByVisaFilterIdJobCode(@Param("jobCode") String jobCode);
}