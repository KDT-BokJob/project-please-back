package com.kdt.please.domain.filter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JobCodeRepository extends JpaRepository<JobCode, String> {
    @Query("select jc.jobName from JobCode jc where jc.jobName like concat('%', :keyword, '%')")
    List<String> findJobNameByKeyword(@Param("keyword") String keyword);

    @Query("select jc.jobCode from JobCode jc where jc.jobName =:keyword")
    List<String> findJobCodeByKeyword(@Param("keyword") String keyword);

    @Query("select jc from JobCode jc where jc.jobName =:keyword")
    Optional<JobCode> findJobCodeByJobName(@Param("keyword") String keyword);
}