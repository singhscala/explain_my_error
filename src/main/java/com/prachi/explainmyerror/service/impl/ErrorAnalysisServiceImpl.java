package com.prachi.explainmyerror.service.impl;

import com.prachi.explainmyerror.dto.ErrorExplanation;
import com.prachi.explainmyerror.dto.ErrorRequest;
import com.prachi.explainmyerror.model.ErrorAnalysis;
import com.prachi.explainmyerror.repository.ErrorAnalysisRepository;
import com.prachi.explainmyerror.service.ErrorAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ErrorAnalysisServiceImpl implements ErrorAnalysisService {

    private final ErrorAnalysisRepository errorAnalysisRepository;

    @Override
    public void addAnalysis(ErrorExplanation errorExplanation, ErrorRequest request) {
        ErrorAnalysis errorAnalysis = new ErrorAnalysis();

        errorAnalysis.setError(request.error());
        errorAnalysis.setErrorType(errorExplanation.errorType());
        errorAnalysis.setWhatHappened(errorExplanation.whatHappened());
        errorAnalysis.setLikelyCause(errorExplanation.likelyCause());
        errorAnalysis.setWhatToCheck(String.join("\n", errorExplanation.whatToCheck()));
        errorAnalysis.setSuggestedFix(errorExplanation.suggestedFix());
        errorAnalysis.setConcepts(String.join("\n", errorExplanation.concepts()));

        errorAnalysisRepository.save(errorAnalysis);
    }

    @Override
    public List<ErrorAnalysis> getAll() {
        return errorAnalysisRepository.findAll();
    }
}
