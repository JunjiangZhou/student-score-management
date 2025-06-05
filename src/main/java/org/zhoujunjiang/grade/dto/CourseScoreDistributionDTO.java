package org.zhoujunjiang.grade.dto;

import lombok.Data;

@Data
public class CourseScoreDistributionDTO {
    private String courseName;
    private Double averageScore;
    private Integer range0to59;
    private Integer range60to69;
    private Integer range70to79;
    private Integer range80to89;
    private Integer range90to100;
}
