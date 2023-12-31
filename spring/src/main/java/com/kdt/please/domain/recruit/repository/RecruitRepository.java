package com.kdt.please.domain.recruit.repository;

import com.kdt.please.domain.recruit.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecruitRepository extends JpaRepository<Recruit, Long> {
    @Query("select r from Recruit r where r.company.companyId=:companyId")
    List<Recruit> findByCompany(@Param("companyId") Long companyId);

    @Query("select r from Recruit r where r.title like concat('%', :keyword, '%')")
    List<Recruit> findByKeyword(@Param("keyword") String keyword);

    @Query(value = "select * from recruit r join company c where r.company_id=c.company_id and c.user_id=:userId", nativeQuery = true)
    List<Recruit> findByRecruiterId(@Param("userId") Long userId);

}