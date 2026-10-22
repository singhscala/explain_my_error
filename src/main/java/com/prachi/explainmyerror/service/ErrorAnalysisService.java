package com.prachi.explainmyerror.service;

import com.prachi.explainmyerror.dto.ErrorExplanation;
import com.prachi.explainmyerror.dto.ErrorRequest;
import com.prachi.explainmyerror.model.ErrorAnalysis;

import java.util.List;

public interface ErrorAnalysisService {

    void addAnalysis(ErrorExplanation errorExplanation, ErrorRequest request);

    List<ErrorAnalysis> getAll();
}
