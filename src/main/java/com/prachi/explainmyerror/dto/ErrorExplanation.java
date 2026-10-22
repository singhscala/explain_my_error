package com.prachi.explainmyerror.dto;

import java.util.List;

public record ErrorExplanation(
        String errorType,
        String whatHappened,
        String likelyCause,
        List<String> whatToCheck,
        String suggestedFix,
        List<String> concepts
) {
}
