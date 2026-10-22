package com.prachi.explainmyerror.repository;

import com.prachi.explainmyerror.model.ErrorAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorAnalysisRepository extends JpaRepository<ErrorAnalysis, Long> {
}
