package com.prachi.explainmyerror.controller;

import com.prachi.explainmyerror.dto.ErrorExplanation;
import com.prachi.explainmyerror.dto.ErrorRequest;
import com.prachi.explainmyerror.model.ErrorAnalysis;
import com.prachi.explainmyerror.service.ErrorAnalysisService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AiController {

    private final ChatClient chatClient;
    private final EmbeddingModel embeddingModel;
    private final ErrorAnalysisService errorAnalysisService;

    @PostMapping("/explain")
    public ErrorExplanation explainError(@RequestBody ErrorRequest request){
        ErrorExplanation errorExplanation =  chatClient
                .prompt()
                .user("""
                You are a Java and Spring debugging assistant.
        
                Analyze the following error and explain it for a Java developer.
        
                Focus on:
                - What the error means
                - The likely cause
                - What the developer should check
                - A practical fix
                - Relevant Java/Spring concepts
        
                Error:
                %s
                """.formatted(request.error()))
                .call()
                .entity(ErrorExplanation.class);

        errorAnalysisService.addAnalysis(errorExplanation, request);

        return errorExplanation;
    }

    @GetMapping("/analysis")
    public List<ErrorAnalysis> getAnalysis(){
        return errorAnalysisService.getAll();
    }

    @GetMapping("/embedding")
    public int embedding(@RequestParam String text) {
        return embeddingModel.embed(text).length;
    }
}
