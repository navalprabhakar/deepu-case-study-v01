package com.example.deepucasestudyv01.casemilestones;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class CaseMilestones {

    private String rowKey;
    private List<Map<String, Object>> caseData;


    public CaseMilestones() {
        caseData = new ArrayList<>();


        // CASE-1
        Map<String, Object> case1Data = new HashMap<String, Object>();

        MilestoneInfo m11 = new MilestoneInfo();
        m11.setInitialReviewDueDate(LocalDateTime.now().toString());
        m11.setInitialReviewCompletionDate(LocalDateTime.now().toString());
        case1Data.put(Milestone.initialReview.name(), m11);

        MilestoneInfo m12 = new MilestoneInfo();
        m12.setProcessReviewDueDate(LocalDateTime.now().toString());
        m12.setProcessReviewCompletionDate(LocalDateTime.now().toString());
        case1Data.put(Milestone.processReview.name(), m12);

        MilestoneInfo m13 = new MilestoneInfo();
        m13.setRiskAnalysisDueDate(LocalDateTime.now().toString());
        m13.setRiskAnalysisCompletionDate(LocalDateTime.now().toString());
        case1Data.put(Milestone.riskAnalysis.name(), m13);

        MilestoneInfo m14 = new MilestoneInfo();
        m14.setResolutionDueDate(LocalDateTime.now().toString());
        m14.setResolutionCompletionDate("");
        case1Data.put(Milestone.resolution.name(), m14);

        MilestoneInfo m15 = new MilestoneInfo();
        m15.setFinalReviewDueDate(LocalDateTime.now().toString());
        m15.setFinalReviewCompletionDate(LocalDateTime.now().toString());
        case1Data.put(Milestone.finalReview.name(), m15);

        MilestoneInfo m16 = new MilestoneInfo();
        m16.setClosureDueDate(LocalDateTime.now().toString());
        m16.setClosureCompletionDate("");
        case1Data.put(Milestone.closure.name(), m16);

        caseData.add(case1Data);

        //CASE-2
        Map<String, Object> case2Data = new HashMap<String, Object>();
        MilestoneInfo m21 = new MilestoneInfo();
        m21.setInitialReviewDueDate(LocalDateTime.now().toString());
        m21.setInitialReviewCompletionDate(LocalDateTime.now().toString());
        case2Data.put(Milestone.initialReview.name(), m21);

        MilestoneInfo m22 = new MilestoneInfo();
        m22.setProcessReviewDueDate(LocalDateTime.now().toString());
        m22.setProcessReviewCompletionDate(LocalDateTime.now().toString());
        case2Data.put(Milestone.processReview.name(), m22);

        caseData.add(case2Data);

        //CASE-3
        Map<String, Object> case3Data = new HashMap<String, Object>();
        MilestoneInfo m31 = new MilestoneInfo();
        m31.setInitialReviewDueDate(LocalDateTime.now().toString());
        m31.setInitialReviewCompletionDate("");
        case3Data.put(Milestone.initialReview.name(), m31);

        MilestoneInfo m35 = new MilestoneInfo();
        m35.setFinalReviewDueDate(LocalDateTime.now().toString());
        m35.setFinalReviewCompletionDate(LocalDateTime.now().toString());
        case3Data.put(Milestone.finalReview.name(), m35);

        MilestoneInfo m36 = new MilestoneInfo();
        m36.setClosureDueDate(LocalDateTime.now().toString());
        m36.setClosureCompletionDate("");
        case3Data.put(Milestone.closure.name(), m36);

        caseData.add(case3Data);

    }

    @NoArgsConstructor
    public enum Milestone {
        initialReview,
        processReview,
        riskAnalysis,
        resolution,
        finalReview,
        closure,
    }
}
