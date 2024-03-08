package com.example.deepucasestudyv01.casemilestones;

import com.fasterxml.jackson.annotation.JsonInclude;
import jdk.jfr.DataAmount;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MilestoneInfo {

    private String initialReviewDueDate;
    private String processReviewDueDate;
    private String riskAnalysisDueDate;
    private String resolutionDueDate;
    private String finalReviewDueDate;
    private String closureDueDate;

    private String initialReviewCompletionDate;
    private String processReviewCompletionDate;
    private String riskAnalysisCompletionDate;
    private String resolutionCompletionDate;
    private String finalReviewCompletionDate;
    private String closureCompletionDate;

    public LocalDateTime toLocalDate(String aDate) {
        return LocalDateTime.parse(aDate);
    }
}
