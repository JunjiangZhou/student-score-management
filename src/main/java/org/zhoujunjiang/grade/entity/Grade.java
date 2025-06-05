package org.zhoujunjiang.grade.entity;

import lombok.Data;

@Data
public class Grade {
    private Integer id;             // 主键
    private Integer enrollmentId;   // 外键：选课记录ID
    private Double score;           // 成绩
    private String grade;           // 等级（可选：A/B/C...）
}
