package com.kdt.please.domain.recruitTag.repository;

import com.kdt.please.domain.recruitTag.RecruitTagMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface RecruitTagMapRepository extends JpaRepository<RecruitTagMap, Long> {

    @Query("select rtm from RecruitTagMap rtm where rtm.recruit.recruitId=:recruitId and rtm.tag.tagId=:tagId")
    Optional<RecruitTagMap> findByRecruitAndTag(@Param("recruitId") Long recruitId, @Param("tagId") Long tagId);

    @Modifying
    @Transactional
    @Query("delete from RecruitTagMap rtm where rtm.recruit.recruitId=:recruitId")
    void deleteByRecruit(@Param("recruitId") Long recruitId);
}