package com.prachi.explainmyerror.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "error_analysis")
@NoArgsConstructor
public class ErrorAnalysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String error;

    private String errorType;

    @Column(columnDefinition = "TEXT")
    private String whatHappened;

    @Column(columnDefinition = "TEXT")
    private String likelyCause;

    @Column(columnDefinition = "TEXT")
    private String whatToCheck;

    @Column(columnDefinition = "TEXT")
    private String suggestedFix;

    @Column(columnDefinition = "TEXT")
    private String concepts;
}
