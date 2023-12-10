package com.kdt.please.domain.languageMapping.repository;

import com.kdt.please.domain.languageMapping.LanguageMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface LanguageMappingRepository extends JpaRepository<LanguageMapping,Long> {
   void deleteByCountryCodeAndKoreaId(String countryCode, String koreaId);

   boolean existsByKoreaId(String koreaId);

   @Transactional
   @Modifying
   @Query("DELETE FROM LanguageMapping lm WHERE lm.koreaId = :koreaId")
   void deleteByKoreaId(@Param("koreaId") Long koreaId);
   Optional<LanguageMapping> findByCountryCodeAndKoreaId(String countryCode, Long koreaId);
}