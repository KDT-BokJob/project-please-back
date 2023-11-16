package com.kdt.please.domain.userVisa.repository;

import com.kdt.please.domain.userVisa.UserVisa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserVisaRepository extends JpaRepository<UserVisa, Long> {
    Optional<UserVisa> findByUser_UserId(Long userId);
    void deleteByUser_UserId(Long userId);

    @Query("select uv.visa.visa from UserVisa uv where uv.user.userId=:userId")
    Optional<String> findVisaByUserId(@Param("userId") Long userId);

    @Modifying
    @Transactional
    @Query(value = "delete from user_visa uv where uv.user_id=:userId", nativeQuery = true)
    void deleteByUserId(@Param("userId") Long userId);
}